package com.st.curd.sec;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {

	private String authority;
	
	
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getAuthority() {
		
		return null;
	}
	

}
