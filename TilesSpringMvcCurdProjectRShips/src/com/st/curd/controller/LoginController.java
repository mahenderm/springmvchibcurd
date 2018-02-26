package com.st.curd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	

	@RequestMapping("gotoLogin")
	public ModelAndView gotoLogin(){
		
		ModelAndView mv=new ModelAndView("login");
		return mv;
		
	}

}
