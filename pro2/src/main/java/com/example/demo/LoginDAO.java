package com.example.demo;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
	 
	public int getCntLogin(Map<String,String> idPwd);

}
