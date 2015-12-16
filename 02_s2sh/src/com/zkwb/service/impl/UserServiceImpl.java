package com.zkwb.service.impl;

import com.zkwb.dao.UserDao;
import com.zkwb.entity.User;
import com.zkwb.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void regist(User user) {
		userDao.save(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
