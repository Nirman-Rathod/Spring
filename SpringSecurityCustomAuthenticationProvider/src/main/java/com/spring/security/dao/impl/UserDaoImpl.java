package com.spring.security.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.security.dao.IUserDao;
import com.spring.security.domain.MyUser;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MyUser getUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MyUser.class);
		criteria.add(Restrictions.eq("username", username));
		MyUser user = (MyUser) criteria.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(MyUser user) {
		sessionFactory.getCurrentSession().save(user);
	}
}
