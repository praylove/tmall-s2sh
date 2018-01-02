package com.tmall.util;

import java.util.List;

public class Page<T> {
	private int currentPage; // 当前页
	private int pageSize; // 页面大小（所容纳事物的数量）
	private int totalCount; // 总的事物数量
	private int startPage; // 起始页
	private List<T> params; // 当前页的事物列表

	public Page() {

	}

	public Page(int startPage, int pageSize) {
		this.startPage = startPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if (totalCount % pageSize != 0) {
			++totalPage;
		}
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public boolean isHasNext() {
		if (currentPage == getTotalPage()) {
			return false;
		}
		return true;
	}

	public boolean isHasPrevious() {
		if (currentPage == getStartPage()) {
			return false;
		}
		return true;
	}

	public List<T> getParams() {
		return params;
	}

	public void setParams(List<T> params) {
		this.params = params;
	}

	public int getPrevious() {
		return currentPage - 1;
	}

	public int getNext() {
		return currentPage + 1;
	}

}
