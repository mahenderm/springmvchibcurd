package com.st.relations.O2O;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;


public class TestOtoO  {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test.xml");
		SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
		Session session=sf.openSession();
		//PassportPojo passport=(PassportPojo)session.get(PassportPojo.class,1);
		PersonPojo person=(PersonPojo) session.get(PersonPojo.class, 1);
		//System.out.println(passport.getAddr());
		//System.out.println(passport.getPerson());
		System.out.println(person.getFname());
		System.out.println(person.getEmail());
		System.out.println(person.getPassport());
		
		
	
	}

}
