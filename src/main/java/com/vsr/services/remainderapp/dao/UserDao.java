package com.vsr.services.remainderapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vsr.services.remainderapp.domain.User;

@Component
public class UserDao {
	

	public UserDao() {
		super();
	}

	public static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("Shiva", 1, new Date()));
		users.add(new User("Rama", 2, new Date()));
		users.add(new User("Krishna", 3, new Date()));
	}
	
	//get all users
	public List<User> findAll(){
		return users;
	}
	//get user by id
	public User findByID(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	//add user to list	
	public User addUser(User user) {
		
			if(user.getId()== 0) {
				user.setId(users.size()+1);
			}			
		
		users.add(user);
		return user;
	}
	
	private static int count = 3;

	public User deleteUser(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return  null;
	}
	
}
