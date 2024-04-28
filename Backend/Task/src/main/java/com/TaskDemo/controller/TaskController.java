package com.TaskDemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskDemo.Entity.Task;
import com.TaskDemo.service.taskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private taskService taskservice;
	
	


	public TaskController(taskService taskservice) {
		this.taskservice = taskservice;
	}


	@Operation(tags = "Get all Task", description = "Get all task present")
	@GetMapping
    public List<Task> getAllTasks() {
        return taskservice.findAllTasks();
    }


	@Operation(tags = "Get Task By Id", description = "Get Task By Id " , responses = {
			@ApiResponse(responseCode = "200",description = "Success"),
			@ApiResponse(responseCode = "400",description = "Not Found")
	})
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
    	Task task =  taskservice.getTaskById(id);
    	if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@Operation(tags = "Create Task", description = "Create New Task")
    @PostMapping
    public ResponseEntity<Long> createTask(@RequestBody Task task) {
    	if(task==null || task.getTaskName()==null || task.getTaskDescription()==null || task.getPriority()==null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
		task.setDateSubmit(new Date());
		Long id = taskservice.createTask(task);
		if(task.getId()!=null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

	@Operation(tags = "Update Task", description = "Update your Task")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        boolean update= taskservice.updateTask(id, task);
        if(update) {
        	return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	
	@Operation(tags = "Delete Your Task", description = "Delete Task By Id ")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean update = taskservice.deleteTask(id);
        if(update) {
        	return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
