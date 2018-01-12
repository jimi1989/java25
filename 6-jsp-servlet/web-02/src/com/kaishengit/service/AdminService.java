package com.kaishengit.service;

import org.apache.commons.codec.digest.DigestUtils;

import com.kaishengit.config.Config;
import com.kaishengit.dao.AdminDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	public Admin login(String userName, String pass) {
		
		Admin admin = adminDao.findByName(userName);
		//对用户输入的明文 + 盐值 进行加密
		pass = DigestUtils.md5Hex(pass + Config.PASSWORD_SALT);
		
		if(admin != null && pass.equals(admin.getPassword())) {
			return admin;
		} else {
			throw new ServiceException("用户名或者密码错误");
		}
		
	}

}
