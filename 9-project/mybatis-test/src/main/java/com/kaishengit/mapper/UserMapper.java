package com.kaishengit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaishengit.entity.User;

public interface UserMapper {

	public User findById(int id);
	public void save(User user);
	public void update(User user);
	public void delete(int id);
	public List<User> findAll();
	
	
}
