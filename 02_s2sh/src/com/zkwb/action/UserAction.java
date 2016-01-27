package com.zkwb.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zkwb.entity.User;
import com.zkwb.service.UserService;

@Controller("userAction")
public class UserAction extends ActionSupport {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Resource(name = "userService")
	private UserService userService;

	public String regist() {
		userService.regist(user);
		return SUCCESS;
	}
}
