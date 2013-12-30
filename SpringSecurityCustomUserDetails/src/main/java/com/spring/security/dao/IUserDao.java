package com.spring.security.dao;

import com.spring.security.domain.MyUser;

public interface IUserDao {

	MyUser getUser(String username);

	void saveUser(MyUser user);
}
