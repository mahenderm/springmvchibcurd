package com.st.curd.pojo;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="audit")
public class AuditPojo {
	private Integer id;
	private String propertyname;
	private String classname;
	private String previousvalue;
	private String currentvalue;
	private String user;
	private Date when;
	private String ipAddress;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPropertyname() {
		return propertyname;
	}
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getPreviousvalue() {
		return previousvalue;
	}
	public void setPreviousvalue(String previousvalue) {
		this.previousvalue = previousvalue;
	}
	public String getCurrentvalue() {
		return currentvalue;
	}
	public void setCurrentvalue(String currentvalue) {
		this.currentvalue = currentvalue;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	public Date getWhen() {
		return when;
	}
	public void setWhen(Date when) {
		this.when = when;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


}
