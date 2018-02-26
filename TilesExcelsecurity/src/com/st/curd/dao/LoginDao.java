package com.st.curd.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.st.curd.sec.AuthorityImpl;
import com.st.curd.sec.UserDetailsImpl;
@Repository

public class LoginDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserDetails getUserDetails(String username){
		
		
		UserDetailsImpl userdetails=null;
		
		List<UserDetailsImpl> userlist=(List<UserDetailsImpl>)hibernateTemplate.find("from UserDetailsImpl u where u.username=?",username);
		
		UserDetailsImpl userDetails=userlist.get(0);
		
		List<AuthorityImpl> authoritylist=(List<AuthorityImpl>)
			hibernateTemplate.find("select a.authority from UserDetailsImpl u join u.authorities a where u.username=? ", username);
	userDetails.setAuthorities(authoritylist);
		
		return userdetails;
	}

}