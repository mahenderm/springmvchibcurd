package com.st.curd.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	

	@RequestMapping("gotoLogin")
	public ModelAndView gotoLogin(){
		Random random=new Random();
		Integer randomval=random.nextInt();
		System.out.println(randomval);
		
		ModelAndView mv=new ModelAndView("login");
		return mv;
		
	}
	
/*	public ModelAndView getOtp(){
		ModelAndView mv=new ModelAndView();
		Random random=new Random();
		Integer randomval=random.nextInt();
		System.out.println(randomval);
		
		return mv;
		
	}*/

}
