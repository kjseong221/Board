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

//-------------------------------------------------------
// LoginController 클래스 선언하기
//-------------------------------------------------------
	// 스프링에서 관용적으로 Controller 라는 단어가 들어간 클래스는
	// URL 주소로 접속 시 대응해서 호출되는 메소드를 소유하고 있다.
	// 클래스 이름 앞에 @Controller 라는 어노테이션이 붙는다.
	// 클래스 내부의 URL 주소 접속 시 호출되는 메소드명 앞에는
	// @RequestMapping 이라는 어노테이션이 붙는다.
	// URL 주소로 접속하면 호출되는 자격을 가진 메소드를 소유한 [컨트롤러 클래스] 선언하기
	// URL 주소로 접속 시 대응해서 호출되는 메소드를 소유하고 있는 클래스를
	// [Controller 클래스 또는 객체]라고 지칭한다.
	//---------------------------------------------------------------------------------------
	//	@Controller 어노테이션이 붙은 클래스 특징
	//---------------------------------------------------------------------------------------
	// (1) 스프링프레임워크가 알아서 객체를 생성하고 관리한다.
	// (2) URL 주소 접속 시 대응해서 호출되는 메소드를 소유하고 있다.
	//---------------------------------------------------------------------------------------

@Controller
public class LoginController {

	@Autowired
	private LoginDAO loginDAO;
	
	@RequestMapping( value="/loginForm.do")
	public ModelAndView loginForm() {
		

		//--------------------------------------
		// [ModelAndView 객체] 생성하기
		//--------------------------------------
		ModelAndView mav = new ModelAndView();

		//-------------------------------------------------------------------------------------------------------
		// [ModelAndView 객체]의 setViewName 메소드 호출하여 [호출할 JSP 페이지명]을 문자로 저장하기
		// [호출할 JSP 페이지명] 앞에 붙는 위치 경로는  application.properties 에서
		// spring.mvc.view.prefix=/WEB-INF/views/ 에 설정한다.
		// [호출할 JSP 페이지명] 뒤에 붙는 위치 경로는  application.properties 에서
		// spring.mvc.view.suffix=.jsp 에 설정한다.
		// <참고> 기본적으로 저장 경로에서 webapp 폴더까지는 자동으로 찾아간다.
		//-------------------------------------------------------------------------------------------------------
		mav.setViewName("loginForm.jsp");
		

		// [ModelAndView 객체] 리턴하기
		return mav;
	}

	
	@RequestMapping( 
			value="/loginProc.do"
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
	)
	@ResponseBody
	public int loginProc(LoginDTO loginDTO){
		
		int loginIdCnt = loginDAO.getCntLogin(loginDTO);
		

		return loginIdCnt;
	}
	
	
	
}
