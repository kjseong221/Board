package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping( value="/loginForm.do")
	public ModelAndView loginForm() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("loginForm.jsp");
		
		return mav;
	}
}
