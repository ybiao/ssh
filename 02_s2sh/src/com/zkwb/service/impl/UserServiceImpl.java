package com.zkwb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkwb.dao.UserDao;
import com.zkwb.entity.User;
import com.zkwb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	public void regist(User user) {
		userDao.save(user);
	}
}
