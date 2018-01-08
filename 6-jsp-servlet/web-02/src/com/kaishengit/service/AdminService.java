package com.kaishengit.service;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	public Admin login(String userName, String pass) {
		
		Admin admin = adminDao.findByName(userName);
		
		if(admin != null && pass.equals(admin.getPassword())) {
			return admin;
		} else {
			throw new ServiceException("用户名或者密码错误");
		}
		
	}

}
