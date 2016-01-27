package com.zkwb.dao.impl;

import org.springframework.stereotype.Repository;

import com.zkwb.dao.UserDao;
import com.zkwb.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
}
