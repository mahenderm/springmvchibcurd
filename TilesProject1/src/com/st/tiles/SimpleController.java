package com.st.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
	@RequestMapping("test1")
	public String test1(){
		System.out.println("iam in test1 controller");
		return "test";
	}
	
	@RequestMapping("test2")
	public String test2(){
		System.out.println("iam in test2 controller");
		return "test1";
	}

}
