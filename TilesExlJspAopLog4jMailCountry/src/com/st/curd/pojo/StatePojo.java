package com.st.curd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class StatePojo {
	private Integer id;
	private String name;
	
	private CountryPojo countrylist;
	
	
	@ManyToOne
	@JoinColumn(name="cid")
public CountryPojo getCountrylist() {
	return countrylist;
}
	public void setCountrylist(CountryPojo countrylist) {
	this.countrylist = countrylist;
}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
