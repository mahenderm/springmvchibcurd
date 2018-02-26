package com.st.curd.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class MailTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("test.xml");
		MailSender mailSender=(MailSender) context.getBean("mailSender");
		String recepientAddress="mahimuthyala051@gmail.com";
		String subject="hello iam mahi";
		String message="hai ra how r u";
		System.out.println("To::"+recepientAddress);
		System.out.println("To::"+subject);
		System.out.println("To::"+message);
		
		SimpleMailMessage email=new SimpleMailMessage();
		email.setTo(recepientAddress);
		email.setSubject(subject);
		email.setText(message);
		System.out.println("started");
		mailSender.send(email);
		
	System.out.println("Done");
	
		
		
	}

}
