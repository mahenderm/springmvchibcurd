package com.st.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
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
	
	
	

}
