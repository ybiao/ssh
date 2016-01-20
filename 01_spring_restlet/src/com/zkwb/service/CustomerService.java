package com.zkwb.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkwb.dao.CustomerDao;
import com.zkwb.entity.Customer;

@Service(value="customerService")
public class CustomerService {
	
	@Resource(name="customerDao")
	private CustomerDao customerDao;

	public void save(Customer cus) {
		customerDao.save(cus);
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
