package com.example.demo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginDAOImpl implements LoginDAO{
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int getCntLogin(LoginDTO loginDTO) {
		int login_idCnt = this.sqlSession.selectOne("com.example.demo.LoginDAO.getCntLogin",loginDTO);
		
		return login_idCnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
