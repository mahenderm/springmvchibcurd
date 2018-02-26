package com.st.curd.sec;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.st.curd.dao.LoginDao;
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private LoginDao loginDao;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loginDao.getUserDetails(username);
		
	/*	AuthorityImpl authority1=new AuthorityImpl();
		authority1.setAuthority("ROLE_USER");
		AuthorityImpl authority2=new AuthorityImpl();
		authority2.setAuthority("ROLE_ADMIN");
		Collection<AuthorityImpl> authorities=new ArrayList<AuthorityImpl>();
		authorities.add(authority1);
		authorities.add(authority2);
		
		
		UserDetailsImpl userdetails=new UserDetailsImpl();
		userdetails.setAccountNonExpired(true);
		userdetails.setAccountNonLocked(true);
		userdetails.setEnabled(true);
		userdetails.setCredentialsNonExpired(true);
		userdetails.setUsername("slokam");
		userdetails.setPassword("slokam");
		userdetails.setAuthorities(authorities);
		*/
		
		
		
	
		
	}
	

}
