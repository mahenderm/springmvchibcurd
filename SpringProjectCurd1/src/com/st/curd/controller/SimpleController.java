package com.st.curd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.curd.pojo.GeoHierPojo;
import com.st.curd.service.GeoHierService;

@Controller
public class SimpleController {
	@Autowired
	private GeoHierService geoHierService;
	
	@RequestMapping(value="geoHirachDisplay")
	public String hello(){
	return"geoHirachDisplay.jsp";
	}
	@RequestMapping(value="saveGeoHirach")
	public String saveGeoHier(GeoHierPojo geoHier){
		geoHierService.saveGeoHier(geoHier);
		 return"saveGeoHirach.jsp";
	}
	@RequestMapping("geoHierList")
	public String getAllGeoHier(HttpServletRequest req){
		
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		req.setAttribute("geoList", geoList);
		return"geoHierList.jsp";
		
	}
	
}
