package com.st.curd.pojo;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="geo")
public class GeoHierPojo implements Comparator<GeoHierPojo> {

	private Integer id;
	private String name;
	private String entitytype;
	private String code;
	private String status;
	private MultipartFile fileData;
	
	private Integer selcountryid;
	
	private Integer selstateid;
	
	
	
	@Transient
	public Integer getSelstateid() {
		return selstateid;
	}
	public void setSelstateid(Integer selstateid) {
		this.selstateid = selstateid;
	}
	@Transient
	public Integer getSelcountryid() {
		return selcountryid;
	}
	public void setSelcountryid(Integer selcountryid) {
		this.selcountryid = selcountryid;
	}
	@Transient
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
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
	public int compare(GeoHierPojo o1, GeoHierPojo o2) {
		
	
		return o1.getName().compareTo(o2.getName());
	}
	
	

}
