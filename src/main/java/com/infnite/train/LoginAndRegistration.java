package com.infnite.train;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAndRegistration {

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String registor(){
		return "register";
	}
	@RequestMapping("/regsucc")
	public String regsucc(){
		return "login";
	}
	
	@RequestMapping("/trainno")
	public String trainno(){
		return "trainno";
	}
	
	@RequestMapping("/trainsd")
	public String trainsd(){
		return "trainsd";
	}
}
