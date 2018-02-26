package com.st.relations.O2M;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="usertab")
public class UserPojo {
	
	
	private Integer id;
	private String name;
	private String addr;
	private Integer phno;
	
	private Collection<PhonePojo> phPojo;
	
	@OneToMany(mappedBy="uPojo")
	public Collection<PhonePojo> getPhPojo() {
		return phPojo;
	}
	public void setPhPojo(Collection<PhonePojo> phPojo) {
		this.phPojo = phPojo;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getPhno() {
		return phno;
	}
	public void setPhno(Integer phno) {
		this.phno = phno;
	}
	
	

}
