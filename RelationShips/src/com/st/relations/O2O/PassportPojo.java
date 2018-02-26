package com.st.relations.O2O;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class PassportPojo {
	private Integer id;
	private Integer passportno;
	private String addr;
	
	private PersonPojo person;
	
	@OneToOne(mappedBy="passport")
	public PersonPojo getPerson() {
		return person;
	}
	public void setPerson(PersonPojo person) {
		this.person = person;
	}
	
	
	public Integer getPassportno() {
		return passportno;
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
	public void setPassportno(Integer passportno) {
		this.passportno = passportno;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
