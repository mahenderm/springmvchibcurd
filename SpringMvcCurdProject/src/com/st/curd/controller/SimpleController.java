package com.st.curd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.st.curd.pojo.GeoHierPojo;
import com.st.curd.service.GeoHierService;

@Controller
public class SimpleController {
	@Autowired
	private GeoHierService geoHierService;
	
	@RequestMapping(value="geoHirachDisplay")
	public ModelAndView hello(){
		GeoHierPojo geo=new GeoHierPojo();
		//req.setAttribute("geo", geo);
		geo.setId(0);
		geo.setName("");
		geo.setEntitytype("");
		geo.setCode("");
		geo.setStatus("");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHirachDisplay.jsp");
		return mv.addObject("geo",geo);
		
	
	}
	@RequestMapping(value="saveGeoHirach")
	public ModelAndView saveGeoHier(GeoHierPojo geoHier){
		geoHierService.saveGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList.jsp");
		return mv.addObject("geoList",geoList);

	
	}
	@RequestMapping("geoHierList")
	public ModelAndView getAllGeoHier(HttpServletRequest req){
		
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList.jsp");
		return mv.addObject("geoList",geoList);
		
	}
	@RequestMapping("getGeoHier")
	public ModelAndView getHierPojo(Integer id){
		GeoHierPojo geo=geoHierService.getHierPojo(id);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHirachDisplay.jsp");
		mv.addObject("geo",geo);
		return mv;

		 
		
	}
	@RequestMapping("updateGeoHier")
	public ModelAndView updateGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.updateGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList.jsp");
		return mv.addObject("geoList",geoList);
		
		
	}
	@RequestMapping("deleteGeoHier")
	public ModelAndView deleteGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.deleteGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("geoHierList.jsp");
		return mv.addObject("geoList",geoList);
		
	}
	
}
