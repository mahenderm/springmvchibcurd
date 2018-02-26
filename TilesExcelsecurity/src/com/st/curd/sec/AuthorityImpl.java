package com.st.curd.sec;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {
	
	private Integer id;

	private String authority;
	
	private UserDetailsImpl user;
@Id
@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_authorities",
			joinColumns={@JoinColumn(name="aid")},
			inverseJoinColumns={@JoinColumn(name="uid")}
						
			)
	public UserDetailsImpl getUser() {
		return user;
	}



	public void setUser(UserDetailsImpl user) {
		this.user = user;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}


@Column(name="authority")
	public String getAuthority() {
		
		return null;
	}
	

}
