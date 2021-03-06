package com.zkwb.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zkwb.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}

	public void delete(String id) {
		Object object = (Object) getSession().get(clazz, id);
		getSession().delete(object);
	}
	
	public void delete(T entity){
		getSession().delete(entity);
	}

	public T getById(String id) {
		return (T) getSession().get(clazz, id);
	}

	public List<T> getAll() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	public List<T> getByIds(String[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return getSession()
				.createQuery(
						"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
				.setParameterList("ids", ids).list();
	}

	public int getTotalCount() {
		int totalCount = ((Long) getSession()
				.createQuery("select count(*) from " + clazz.getSimpleName())
				.uniqueResult()).intValue();
		return totalCount;
	}

	public String save(T entity) {
		String id =  getSession().save(entity) + "";
		return id;
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public int update(String hql, Object... field) {
		Query query = getSession().createQuery(hql);
		if (field.length != 0) {
			for (int i = 0; i < field.length; i++) {
				query.setParameter(i, field[i]);
			}
		}
		return query.executeUpdate();
	}

	/*
	 * public Pagination getPagination(int pageNo, int pageSize) { Pagination
	 * pagination = new Pagination(pageNo, pageSize, getTotalCount()); List<T>
	 * list = getSession() .createQuery("from " +
	 * clazz.getSimpleName()).setFirstResult(
	 * pagination.getFirstResult()).setMaxResults(
	 * pagination.getPageSize()).list(); pagination.setList(list); return
	 * pagination; }
	 */

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
