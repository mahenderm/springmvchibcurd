package com.st.relations.O2M;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="phone")
public class PhonePojo {
	
	private Integer id;
	private String network;
	
	private UserPojo uPojo;
	
	
	
	@ManyToOne
	@JoinColumn(name="userph")
	public UserPojo getuPojo() {
		return uPojo;
	}
	public void setuPojo(UserPojo uPojo) {
		this.uPojo = uPojo;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	
	}
