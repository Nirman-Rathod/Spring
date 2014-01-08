package com.spring.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.dao.IUserDao;
import com.spring.security.domain.MyUser;
import com.spring.security.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Transactional
	@Override
	public void saveUser(MyUser user) {
		userDao.saveUser(user);
	}

}
