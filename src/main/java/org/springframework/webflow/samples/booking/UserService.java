package org.springframework.webflow.samples.booking;


import model.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.webflow.samples.booking.config.MongoConfig;

import repository.UserRepository;

public class UserService {
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public UserService(){
		
	}
	
	public UserService(String name, String password){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		if(userRepo.findByUsernameAndPassword(name, password) != null){
			user = userRepo.findByUsername(name);
			System.out.println("current user:" + user.getUsername());
		}
		ctx.close();
	}
	
	public boolean validUser(String name, String password){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		UserRepository userRepo = ctx.getBean(UserRepository.class);
		boolean res = false;
		if(userRepo.findByUsernameAndPassword(name, password) != null)
			res = true;
		ctx.close();
		return res;
	}
}
