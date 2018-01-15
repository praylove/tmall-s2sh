package com.tmall.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tmall.beans.Order;
import com.tmall.service.OrderService;
import com.tmall.util.Page;

public class OrderAction extends ActionSupport {
	private Page<Order> page;
	private OrderService orderService;
	private Order order;

	public String list() {
		page = orderService.list(page);
		return SUCCESS;
	}

	public String delivery() {
		orderService.delivery(order);
		return SUCCESS;
	}

	public String pay() {
		return SUCCESS;
	}

	public String confirm() {
		return SUCCESS;
	}

	public String review() {
		return SUCCESS;
	}

	public Page<Order> getPage() {
		return page;
	}

	public void setPage(Page<Order> page) {
		this.page = page;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
