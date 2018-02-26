package com.st.curd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.st.curd.pojo.GeoHierPojo;
@Component
public class GeoHierDao {


	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void saveGeoHier(GeoHierPojo geoHier){
		hibernateTemplate.save(geoHier);
		
		
	}
	public List<GeoHierPojo> getAllGeoHier(){
		List<GeoHierPojo> geoList=(List<GeoHierPojo>)hibernateTemplate.find("from GeoHierPojo");
		return geoList;
		
		
	}
	public void deleteGeoHier(GeoHierPojo geohier){
		hibernateTemplate.delete("from GeoHierPojo");
		
	}

}
