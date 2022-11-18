package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@Autowired
	private LoginDAO loginDAO;
	
	// 로그인 UI 연결
	@RequestMapping( value="/loginForm.do")
	public ModelAndView loginForm() {
		

		ModelAndView mav = new ModelAndView();

		mav.setViewName("loginForm.jsp");
		
		return mav;
	}

	// 로그인 성공/실패 여부 비동기식으로 DB와 연동 후 결과 리턴
	@RequestMapping( 
			value="/loginProc.do"
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public int loginProc(LoginDTO loginDTO,HttpSession session,HttpServletResponse response){
		
		int loginIdCnt = loginDAO.getCntLogin(loginDTO);
		
		if(loginIdCnt==1) {
			
			session.setAttribute("mid", loginDTO.getMid());

			
			if(loginDTO.getIs_login()==null) {
				
				Cookie cookie1 = new Cookie("mid",null);
				cookie1.setMaxAge(0);

				Cookie cookie2 = new Cookie("pwd",null);
				cookie2.setMaxAge(0);

				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			else {
				Cookie cookie1 = new Cookie("mid",loginDTO.getMid());
				cookie1.setMaxAge(60*60*24);
				
				Cookie cookie2 = new Cookie("pwd",loginDTO.getPwd());
				cookie2.setMaxAge(60*60*24);
				
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			
		}
		

		return loginIdCnt;
	}
	
	
	
}
