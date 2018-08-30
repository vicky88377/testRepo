package com.training.reactive.service;

import com.training.reactive.model.Person;

import reactor.core.publisher.Flux;

public interface UserDetailInterface {
	
	public Flux<Person> findAllUsers();

}
