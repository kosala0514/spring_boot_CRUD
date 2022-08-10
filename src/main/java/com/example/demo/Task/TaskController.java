package com.example.demo.Task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping(path="/tasks")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@PostMapping("/add")
	public TaskItem addTask(@Valid @RequestBody TaskItem taskItem) {
		return taskRepository.save(taskItem);
	}
	
	@GetMapping
	public List<TaskItem> getTask(){
		return taskRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateTask(@PathVariable long id) {
		boolean exist = taskRepository.existsById(id);
		if(exist) {
			TaskItem task = taskRepository.getById(id);
			boolean done = task.isDone();
			task.setDone(!done);
			taskRepository.save(task);
			return new ResponseEntity<>("Task is updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteTask(@PathVariable long id) {
		boolean exist = taskRepository.existsById(id);
		if(exist) {
			taskRepository.deleteById(id);
			return new ResponseEntity<>("Task is deleted", HttpStatus.OK);
		}
		return new ResponseEntity<>("Task is not exist", HttpStatus.BAD_REQUEST);
	}
	
}
