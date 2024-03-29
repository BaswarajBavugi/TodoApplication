package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<>();
	private static int todoCount=0;
	static {
		todos.add(new Todo(++todoCount,"Baswaraj","Learn Linux",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"Baswaraj","Learn AWS",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"Baswaraj","Learn Git",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username,String Description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount,username,Description,targetDate,done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		 deleteById(todo.getId());
		 todos.add(todo);
		 
		
	}
}
