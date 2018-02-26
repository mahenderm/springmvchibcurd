package com.st.curd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.st.curd.pojo.CountryPojo;
import com.st.curd.pojo.StatePojo;
@Repository
public class MetaDataDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<CountryPojo> getDataFromCountry(){
		return (List<CountryPojo>) hibernateTemplate.find("from CountryPojo");
	}
	
	public List<StatePojo> getDataFromState(Integer cid){
		System.out.println("iam stateid");
		//return (List<StatePojo>) hibernateTemplate.find("select s from StatePojo s join s.country where c.id=?",cid);
		return (List<StatePojo>) hibernateTemplate.find("select s from CountryPojo c join c.statelist  s where c.id=?",cid);
	}
}
