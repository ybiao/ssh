package com.zkwb.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zkwb.entity.User;
import com.zkwb.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private static final long serialVersionUID = 7171938708302701033L;

	public String regist() {
		userService.regist(user);
		return SUCCESS;
	}

	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
