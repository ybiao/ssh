package com.zkwb.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.zkwb.dao.CustomerDao;
import com.zkwb.entity.Customer;

@Repository(value="customerDao")
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
	public void save(Customer customer){
		String sql = "insert into customer (cid,cname) values (?,?)";
		this.getJdbcTemplate().update(sql,new Object[]{customer.getCid(),customer.getCname()});
	}
}
