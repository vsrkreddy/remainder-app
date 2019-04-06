package com.vsr.services.remainderapp.jaxrs;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.services.remainderapp.domain.Dummy;
import com.vsr.services.remainderapp.domain.User;

@RestController
public interface RemainderResource {

	@RequestMapping(method = RequestMethod.GET, path ="/hello")
	public String hello();
	
	/*Gives json response*/	
	@GetMapping(path="/dummy")
	public Dummy dummyMethod();
	
	@GetMapping(path ="/users")
	public List<User> findAll();
	
	@GetMapping(path = "/users/{id}")
	public User findById(@PathVariable Integer id);
	
	@PostMapping(path = "/users/user")
	public User createUser(@Valid @RequestBody User user);	
	
	@DeleteMapping(path ="/users/delete/{id}")
	public void deleteUser(@PathVariable Integer id);
	
}
