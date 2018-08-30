package com.training.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.reactive.dao.UserRepoInterface;
import com.training.reactive.model.Person;

import reactor.core.publisher.Flux;

@Component
public class UserDetailServiceImpl implements UserDetailInterface {

	@Autowired
	UserRepoInterface userRepo;
	
	
	@Override
	public Flux<Person> findAllUsers() {
		Flux<Person> userList=userRepo.findAll();
		
		return userList;
		
	}
}
