package com.tmall.dao;

/**
 * DAO接口
 * 
 * @author sherl
 *
 */
public interface DAO {
	void add(Object o);

	void update(Object o);

	void delete(Object o);

	Object get(Class<?> c, int id);
}
