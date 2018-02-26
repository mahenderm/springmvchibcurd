package com.st.relations.M2M;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMtoM {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test.xml");
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
		Session session=sf.openSession();
		
		AuthorityImpl authority=(AuthorityImpl)session.get(AuthorityImpl.class, 1);
		System.out.println(authority.getAuthority());
		Collection<UserDetailsImpl> userdetails=(Collection<UserDetailsImpl>) authority.getUserDetail();
		for(UserDetailsImpl aimpl:userdetails){
			System.out.println(aimpl.getUsername());
		
		
		}
		session.close();
		
	}

}
