package com.training.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.reactive.dao.UserRepoInterface;
import com.training.reactive.model.Person;
import com.training.reactive.service.UserDetailInterface;
import com.training.reactive.service.UserDetailServiceImpl;

import reactor.core.publisher.Flux;
@RestController
@Configuration
public class PersonRoutesConfig {
  
	
	@Autowired
	UserDetailInterface userDetails;
	
	@Autowired
	UserRepoInterface userRepo;
	@Bean
    RouterFunction<?> routes(UserRepoInterface personRespository) {
        return nest(path("/person"),

          route(RequestPredicates.GET("/{id}"),
            request -> ok().body(personRespository.findById(request.pathVariable("id")), Person.class))

            .andRoute(method(HttpMethod.POST),
              request -> {
                personRespository.insert(request.bodyToMono(Person.class)).subscribe();
            return ok().build();
        })
        );
    }
	
	
	
	@RequestMapping(value="/person/getAll",method=RequestMethod.GET,produces= {"application/json"})
	public Flux<Person> getAllUsers(){
		System.out.println("User--->");
		Flux<Person> userList=userDetails.findAllUsers();
		userList.collectList();
		System.out.println("User--->"+userList.collectList());
		return userList;
	}
	
	@RequestMapping(value="/person/add",method=RequestMethod.POST,consumes= {"application/json"},produces= {"application/json"})
	public void addUser(Person personObj) {
		userRepo.save(personObj);
		Person person= new Person();
		
	}
	
	
	
}
