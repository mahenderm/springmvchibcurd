package com.st.relations.O2O;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

@Entity
@Table(name="person")
public class PersonPojo {
	private Integer id;
	//@Column(unique=true)
	private String fname;
	private String email;
	
	private PassportPojo passport;
	
	@OneToOne
	@JoinColumn(name="passportno")
	public PassportPojo getPassport() {
		return passport;
	}
	public void setPassport(PassportPojo passport) {
		this.passport = passport;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="fname")
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

}
