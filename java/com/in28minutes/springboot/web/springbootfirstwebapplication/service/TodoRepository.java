package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	//***This method needs to be defined by us because JPA doesnt have a method that finds a user by name
	//service.retrieveTodos(name)
	List<Todo> findByUser(String user);
	
	//*****All of these already have a method in JPA
	//service.deleteTodo(id)
	//service.retrieveTodo(id)
	//service.updateTodo(todo)
	//service.addTodo(service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false))
	
	
}