package com.st.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.st.curd.dao.GeoHierDao;
import com.st.curd.pojo.GeoHierPojo;

@Component
public class GeoHierService {
	@Autowired
	private GeoHierDao geoHierDao;
	@Transactional
	public void saveGeoHier(GeoHierPojo geoHier){
		geoHierDao.saveGeoHier(geoHier);
		
	}
	@Transactional
	public List<GeoHierPojo> getAllGeoHier(){
		return geoHierDao.getAllGeoHier();
		
	}
	@Transactional(readOnly=true)
	public GeoHierPojo getHierPojo(Integer id){
		return geoHierDao.getHierPojo(id);
		
	}
	@Transactional
	public void updateGeoHier(GeoHierPojo geoHier){
		geoHierDao.updateGeoHier(geoHier);
		
	}
	@Transactional
	public void deleteGeoHier(GeoHierPojo geoHier){
		geoHierDao.deleteGeoHier(geoHier);
	
	}
	}
	
	
	


