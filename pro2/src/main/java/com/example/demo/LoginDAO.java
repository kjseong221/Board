package com.example.demo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
	public int getCntLogin(LoginDTO loginDTO); 
}
