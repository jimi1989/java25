package com.kaishengit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kaishengit.entity.Account;

public interface AccountMapper {

//	public Account findByNameAndPassword(String userName, String password);
	public Account findByNameAndPassword(@Param("username") String userName,@Param("password") String password);
	
	public Account findByNameOrEamil(Map<String,String> params);
	public Account findByNameOrEamil2(Map<String,String> params);
	
	public void batchInsert(List<Account> list);
	
}
