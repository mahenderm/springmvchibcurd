package com.st.curd.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String saveGeoHier(GeoHierPojo geoHier){
		System.out.println(geoHier.getFileData().getOriginalFilename());
		
		geoHierService.saveGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList");
		//return mv.addObject("geoList",geoList);
		MultipartFile multiPart=geoHier.getFileData();
		File file=new File("E:\\SLOKAM\\uploadfiles\\"+multiPart.getOriginalFilename());
		try {
			multiPart.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:geoHierList.do";

	
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
