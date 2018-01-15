package com.tmall.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.beans.Order;
import com.tmall.beans.OrderItem;
import com.tmall.dao.DAOimpl;
import com.tmall.util.Page;

@Transactional
public class OrderService {
	private DAOimpl dao;

	private enum Status {
		UNPAY("unpay"), UNDELIVERY("undelivery"), UNCONFIRM("unconfirm"), UNREVIEW("unreview"), SUCCESS("success");

		private String value;

		Status(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	};

	public void setDao(DAOimpl dao) {
		this.dao = dao;
	}

	public void add(Order o) {
		o.setStatus(Status.UNPAY.getValue());
		dao.add(o);
	}

	public void update(Order o) {
		dao.update(o);
	}

	public void delete(Order o) {
		dao.delete(o);
	}

	public Order get(int id) {
		Order order = (Order) dao.get(Order.class, id);
		fillTotal(order);
		return order;
	}

	public Page<Order> list(Page<Order> page) {
		int beg = (page.getCurrentPage() - 1) * page.getPageSize();
		if (beg < 0) {
			beg = 0;
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		List<Order> os = (List<Order>) dao.listForPage(criteria, beg, page.getPageSize());

		for (Order o : os) {
			fillTotal(o);
		}

		page.setTotalCount(dao.getTotal(Order.class));
		page.setParams(os);

		return page;
	}

	private void fillTotal(Order o) {
		float totalPrice = 0;
		int totalCount = 0;
		for (OrderItem oi : o.getOrderItems()) {
			int count = oi.getNumber();
			totalCount += count;
			totalPrice += oi.getProduct().getPromotePrice() * count;
		}
		o.setTotal(totalPrice);
		o.setTotalNumber(totalCount);
	}

	private void updateStatus(Order o, Status status) {
		o.setStatus(status.getValue());
		update(o);
	}

	public void pay(Order o) {
		updateStatus(o, Status.UNDELIVERY);
	}

	public void delivery(Order o) {
		updateStatus(o, Status.UNCONFIRM);
	}

	public void confirm(Order o) {
		updateStatus(o, Status.UNREVIEW);
	}

	public void review(Order o) {
		updateStatus(o, Status.SUCCESS);
	}
}
