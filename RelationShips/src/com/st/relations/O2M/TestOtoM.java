package com.st.relations.O2M;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOtoM {
@Test
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test.xml");
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
		Session session=sf.openSession();
		UserPojo upojo=(UserPojo)session.get(UserPojo.class, 2);
		System.out.println(upojo.getName());
		System.out.println(upojo.getName());
		Collection<PhonePojo> plist=(Collection<PhonePojo>)upojo.getPhPojo();
		for(PhonePojo ppojo:plist){
			System.out.println(ppojo.getNetwork());
			
		}
		
	session.close();

	}
}
