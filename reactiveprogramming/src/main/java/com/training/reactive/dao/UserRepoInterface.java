package com.training.reactive.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.training.reactive.model.Person;

import reactor.core.publisher.Flux;

public interface UserRepoInterface extends ReactiveMongoRepository<Person, String> {
	Flux<Person> findByName(String name);
}
