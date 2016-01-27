package com.zkwb.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	public void delete(String id);

	public T getById(String id);

	public List<T> getAll();

	public List<T> getByIds(String[] ids);

	public int getTotalCount();

	public String save(T entity);

	public void update(T entity);

	public int update(String hql, Object... field);

	/*
	 * public Pagination getPagination(int pageNo, int pageSize) { Pagination
	 * pagination = new Pagination(pageNo, pageSize, getTotalCount()); List<T>
	 * list = getSession() .createQuery("from " +
	 * clazz.getSimpleName()).setFirstResult(
	 * pagination.getFirstResult()).setMaxResults(
	 * pagination.getPageSize()).list(); pagination.setList(list); return
	 * pagination; }
	 */

	public Session getSession();
}
