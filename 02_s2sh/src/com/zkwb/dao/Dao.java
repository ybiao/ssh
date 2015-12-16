package com.zkwb.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	public List<T> getAllEntitys();
	public T getEntityById(Serializable id);
}
