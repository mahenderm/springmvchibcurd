package com.st.curd.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class CountryPojo {
	private Integer id;
	private String name;
	private String des;
	
	private List<StatePojo> statelist;
	
	@OneToMany(mappedBy="countrylist")
	public List<StatePojo> getStatelist() {
		return statelist;
	}
	public void setStatelist(List<StatePojo> statelist) {
		this.statelist = statelist;
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
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
	

}
