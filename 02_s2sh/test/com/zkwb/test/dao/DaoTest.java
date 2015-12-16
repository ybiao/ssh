package com.zkwb.test.dao;

import java.util.List;

import org.junit.Test;

import com.zkwb.dao.TestDao;
import com.zkwb.entity.User;

public class DaoTest {
	private TestDao testDao;
	@Test
	public void testGetAll(){
		List<User> users = this.testDao.getAllEntitys();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
