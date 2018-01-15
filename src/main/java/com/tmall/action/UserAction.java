package com.tmall.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.User;
import com.tmall.service.UserService;
import com.tmall.util.Page;

public class UserAction extends ActionSupport {
	private UserService userService;
	private Page<User> page;
	private User user;

	public String add() {
		userService.add(user);
		return SUCCESS;
	}

	public String delete() {
		userService.delete(user);
		return SUCCESS;
	}

	public String list() {
		page = userService.list(page);
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
