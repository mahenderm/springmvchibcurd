package com.st.curd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="geo")
public class GeoHierPojo implements Comparable<GeoHierPojo>{

	private Integer id;
	private String name;
	private String entitytype;
	private String code;
	private String status;
	
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
	
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int compareTo(GeoHierPojo o) {
		return this.name.compareTo(o.getName());
		
		
		 
	}
	public int compareTo1(GeoHierPojo o) {
		return this.entitytype.compareTo(o.getEntitytype());
		
		
	}
	
	public int compareTo2(GeoHierPojo o) {
		return this.code.compareTo(o.getCode());
		
		
	}
	public int compareTo3(GeoHierPojo o) {
		return this.status.compareTo(o.getStatus());
		
		
	}
	
	

}
