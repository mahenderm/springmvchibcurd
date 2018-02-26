package com.st.curd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
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
	public String hello(HttpServletRequest req){
		GeoHierPojo geo=new GeoHierPojo();
		req.setAttribute("geo", geo);
		geo.setName("");
		geo.setEntitytype("");
		geo.setCode("");
		geo.setStatus("");
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
	@RequestMapping("getGeoHier")
	public String getHierPojo(Integer id,HttpServletRequest req){
		GeoHierPojo geo=geoHierService.getHierPojo(id);
		req.setAttribute("geo", geo);	
		return"geoHirachDisplay.jsp";
		 
		
	}
	@RequestMapping("updateGeoHier")
	public String updateGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.updateGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		req.setAttribute("geoList", geoList);
		return"geoHierList.jsp";
		
		
	}
	@RequestMapping("deleteGeoHier")
	public String deleteGeoHier(GeoHierPojo geoHier,HttpServletRequest req){
		geoHierService.deleteGeoHier(geoHier);
		List<GeoHierPojo> geoList=geoHierService.getAllGeoHier();
		req.setAttribute("geoList", geoList);
		return"geoHierList.jsp";
		
	}
	
}
