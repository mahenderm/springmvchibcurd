package com.st.curd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hmef.Attachment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.st.curd.pojo.ExcelPojo;
import com.st.curd.pojo.GeoHierPojo;
import com.st.curd.service.GeoHierService;

@Controller
public class SimpleController {

	
	@Autowired
	private GeoHierService geoHierService;
	
	@RequestMapping("geoHirachDisplay")
	public ModelAndView hello(){
		GeoHierPojo geo=new GeoHierPojo();
		//req.setAttribute("geo", geo);
		geo.setId(0);
		geo.setName("");
		geo.setEntitytype("");
		geo.setCode("");
		geo.setStatus("");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHirachDisplay");
		return mv.addObject("geo",geo);
		
	
	}
	@RequestMapping("saveGeoHirach")
	public ModelAndView saveGeoHier(GeoHierPojo geoHier,HttpServletRequest request){
		System.out.println(geoHier.getFileData().getOriginalFilename());
		
		geoHierService.saveGeoHier(geoHier);
	/*	List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList");*/
		//return mv.addObject("geoList",geoList);
		MultipartFile multiPart=geoHier.getFileData();
		File file=new File("E:\\SLOKAM\\uploadfiles\\"+multiPart.getOriginalFilename());
		/*ExcelPojo ex=new ExcelPojo();*/
		List<ExcelPojo> excellist=new ArrayList<ExcelPojo>();
		
		
		try {
			multiPart.transferTo(file);
			
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook=new XSSFWorkbook(fis);
			Sheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rows=sheet.iterator();
			
			rows.next();
			while(rows.hasNext()){
				ExcelPojo ex=new ExcelPojo();
				Row row=rows.next();
				Iterator<Cell> cells=row.cellIterator();
				
				
				while(cells.hasNext()){
					Cell cell=cells.next();
					
					
					
					if(cell.getColumnIndex()==0){
						Double d=cell.getNumericCellValue();
					ex.setId(d.intValue());
						
					}
					else if(cell.getColumnIndex()==1){
						ex.setName(cell.getStringCellValue());
					}
					else if(cell.getColumnIndex()==2){
						ex.setAddr(cell.getStringCellValue());
					}
				else if(cell.getColumnIndex()==3){
						ex.setQual(cell.getStringCellValue());
					}
					
					/*if(row.getRowNum()==1 && cell.getColumnIndex()==0)
						ex.setName(cell.getStringCellValue());
					if(row.getRowNum()==1 && cell.getColumnIndex()==1)
						ex.setAddr(cell.getStringCellValue());
				
					if(row.getRowNum()==1 && cell.getColumnIndex()==2)
						ex.setQual(cell.getStringCellValue());*/
					
					
					/*ex.setName(cell.getStringCellValue());
					ex.setAge(cell.getStringCellValue());
					ex.setQual(cell.getStringCellValue());
					ex.setQual(cell.getStringCellValue());*/
					
				
					/*List<ExcelPojo> excellist=new ArrayList<ExcelPojo>();*/
					
					//request.setAttribute("excellist", excellist);
				/*	
					switch(cell.getCellType()){
				case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue());break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(cell.getNumericCellValue());break;
						
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.println(cell.getBooleanCellValue());break;
						
					}*/
					
				}
				excellist.add(ex);
				
				
			}
			
			workbook.close();
			System.out.println(excellist);
		
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "redirect:geoHierList.do";
		/*return "excel";*/
		ModelAndView mv=new ModelAndView();
		mv.addObject("excellist",excellist);
		mv.setViewName("excel");
		return mv;

	
	}
	@RequestMapping("download")
	public void download(String file,HttpServletResponse response) throws IOException{
		response.setHeader("Content-Disposition", "attachment; filename="+file);
		FileInputStream fis=new FileInputStream("E:\\SLOKAM\\uploadfiles\\"+file);
		OutputStream os=response.getOutputStream();
		int data=fis.read();
		while(data!=-1){
			os.write(data);
			data=fis.read();
		}
		os.close();
		}
	

	
	@RequestMapping("geoHierList")
	public ModelAndView getAllGeoHier(HttpSession session){
	System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());	
		
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		List<GeoHierPojo> subList=geoList.subList(0, 5);
		session.setAttribute("pageno", 1);
		ModelAndView mv=new ModelAndView();
		/*mv.setViewName("geoHierList.jsp");*/
		mv.setViewName("geoHierList");
		return mv.addObject("geoList",subList);
		
	}
	
	@RequestMapping("getnextpage")
	public ModelAndView getNextPageGeoHier(HttpSession session){
		String end=(String)session.getAttribute("end");
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		Integer pageno=(Integer)session.getAttribute("pageno");
		
		if(end==null || !end.equals("yes"))
	
		pageno++;
		session.setAttribute("pageno", pageno);
		int endno=pageno*5;
		int startno=endno-5;
		
		
		
		if(geoList.size()<=endno){
			endno=geoList.size();
			session.setAttribute("end", "yes");
		}
		List<GeoHierPojo> subList=geoList.subList(startno, endno);
		
		ModelAndView mv=new ModelAndView();
		/*mv.setViewName("geoHierList.jsp");*/
		mv.setViewName("geoHierList");
		return mv.addObject("geoList",subList);
		
	}
	
	
	
	@RequestMapping("getprevpage")
	public ModelAndView getPrevPageGeoHier(HttpSession session){
		session.setAttribute("end", "No");
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
	
		Integer pageno=(Integer)session.getAttribute("pageno");
		if(pageno>1){
			pageno--;
			/*session.setAttribute("pageno", pageno);*/
		}
	
		int endno=pageno*5;
		int startno=endno-5;
		session.setAttribute("pageno", pageno);
		
		
		/*if(geoList.size()<=endno){
			endno=geoList.size();
			session.setAttribute("end", "yes");
		}*/
		List<GeoHierPojo> subList=geoList.subList(startno, endno);
		
		ModelAndView mv=new ModelAndView();
		/*mv.setViewName("geoHierList.jsp");*/
		mv.setViewName("geoHierList");
		return mv.addObject("geoList",subList);
		
	}
	
	
	
	
	@RequestMapping("getGeoHier")
	public ModelAndView getHierPojo(Integer id){
		GeoHierPojo geo=geoHierService.getHierPojo(id);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHirachDisplay");
		mv.addObject("geo",geo);
		return mv;

		 
		
	}
	@RequestMapping("updateGeoHier")
	public ModelAndView updateGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.updateGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList");
		return mv.addObject("geoList",geoList);
		
		
	}
	@RequestMapping("deleteGeoHier")
	public ModelAndView deleteGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.deleteGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList");
		return mv.addObject("geoList",geoList);
		
	}
	@RequestMapping("name")
	public ModelAndView sorting(){
		ModelAndView mv=new ModelAndView();
		
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		Collections.sort(geoList,new GeoHierPojo() );
		mv.setViewName("geoHierList");
		mv.addObject("geoList",geoList);
		
		return mv;
		
	}
	
	
}
