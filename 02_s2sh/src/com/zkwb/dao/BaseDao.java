package com.zkwb.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	
	/**
	 * 根据实体类删除对象
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 根据ID删除对象
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 根据ID获取对象
	 * @param id
	 * @return
	 */
	public T getById(String id);

	/**
	 * 获取所有对象，封装成List
	 * @return
	 */
	public List<T> getAll();

	/**
	 * 根据ID获取对象
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(String[] ids);

	/**
	 * 获取所有记录数
	 * @return
	 */
	public int getTotalCount();

	/**
	 * 根据对象保存数据
	 * @param entity
	 * @return
	 */
	public String save(T entity);

	/**
	 * 根据对象更新数据
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据参数更新数据
	 * @param hql
	 * @param field
	 * @return
	 */
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
