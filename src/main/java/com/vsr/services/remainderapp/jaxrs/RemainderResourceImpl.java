package com.vsr.services.remainderapp.jaxrs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vsr.services.remainderapp.dao.UserDao;
import com.vsr.services.remainderapp.domain.Dummy;
import com.vsr.services.remainderapp.domain.User;
import com.vsr.services.remainderapp.exception.CustomisedExceptionHandler;
import com.vsr.services.remainderapp.exception.UserNotFoundException;

@Component
public class RemainderResourceImpl implements RemainderResource {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String hello() {
		System.out.println("Hello");
		return "HelloWorld";
	}
	
	public Dummy dummyMethod() {
		return new Dummy("Hello World");
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public User findById(Integer id){
		
		User user = userDao.findByID(id);
		if(user == null) {
			throw new UserNotFoundException("User Not Found");
		}
		return user;
	}
;
	@Override
	public User createUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		User user =userDao.deleteUser(id);	
		if(user == null) {
			throw new UserNotFoundException("User not found");
		}
	}

}
