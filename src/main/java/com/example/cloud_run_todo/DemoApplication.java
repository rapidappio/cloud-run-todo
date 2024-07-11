package com.example.cloud_run_todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.List;

import static java.util.Collections.emptyList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/api/v1/todos")
class TodoController {

	private final TodoRepository todoRepository;

    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

	@PostMapping
    void create(@RequestBody CreateTodoRequest request) {
		this.todoRepository.save(new Todo(request.getDescription(), false));
	}

	@GetMapping
	Iterable<Todo> list() {
		return this.todoRepository.findAll();
	}
}

@Entity
class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	private Boolean completed;

	public Todo(String description, Boolean completed) {
		this.description = description;
		this.completed = completed;
	}

	public Todo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}

class CreateTodoRequest {
	private String description;

	public CreateTodoRequest(String description) {
		this.description = description;
	}

	public CreateTodoRequest() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

interface TodoRepository extends CrudRepository<Todo, String>{}