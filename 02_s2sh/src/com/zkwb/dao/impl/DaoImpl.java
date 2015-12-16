package com.zkwb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zkwb.dao.Dao;

public class DaoImpl<T> extends JdbcDaoSupport implements Dao<T> {
	private Class clazz;
	
	public DaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}

	public List<T> getAllEntitys() {
		String sql = "select * from " + this.clazz.getSimpleName();
		List<T> lists = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(this.clazz));
		return lists;
	}

	public T getEntityById(Serializable id) {
		return null;
	}
	
}
