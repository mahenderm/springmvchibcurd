package com.st.curd.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.curd.dao.MetaDataDao;
import com.st.curd.pojo.CountryPojo;
import com.st.curd.pojo.StatePojo;
@Service
public class MetaDataService {
	@Autowired
	private MetaDataDao metaDataDao;
	
	public List<CountryPojo> getDataFromCountry(){
	return metaDataDao.getDataFromCountry();
		
	}
	
	public List<StatePojo> getDataFromState(Integer cid){
		return metaDataDao.getDataFromState(cid);
			
		}

}
