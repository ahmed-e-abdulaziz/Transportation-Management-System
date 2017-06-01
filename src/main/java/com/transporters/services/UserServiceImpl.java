package com.transporters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transporters.dao.UserDAO;
import com.transporters.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> listAll() {
		return (List<User>) userDAO.listAll();
	}

	@Override
	@Transactional
	public User getById(Integer id) {
		return userDAO.getById(id);
	}

	@Override
	@Transactional
	public User save(User domainObject) {
		return userDAO.save(domainObject);
	}

	@Override
	@Transactional
	public User update(User domainObject) {
		return userDAO.update(domainObject);
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		return userDAO.delete(id);
	}

}
