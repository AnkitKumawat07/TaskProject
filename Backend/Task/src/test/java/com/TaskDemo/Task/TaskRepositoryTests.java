package com.TaskDemo.Task;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TaskDemo.Entity.Task;
import com.TaskDemo.Repository.TaskRepository;

@SpringBootTest
public class TaskRepositoryTests {

	@Autowired
	private TaskRepository taskRepository;
	
	@Test
	public void testCreateTask() {
		Task newTask = new Task();
		newTask.setTaskName("Task Test1");
		newTask.setTaskDescription("Test Tasl Working");
		newTask.setDateSubmit(new Date());
		newTask.setPriority((short) 5);
		taskRepository.save(newTask);
		assertThat(newTask.getId()).isNotNull();
	}
	
	@Test
	public void testFindTaskById() {
		Task newTask = new Task();
		newTask.setTaskName("Task Test Task By Id ");
		newTask.setTaskDescription("Test Task by Id is working or not");
		newTask.setDateSubmit(new Date());
		newTask.setPriority((short) 5);
		taskRepository.save(newTask);
		
		Task actual = taskRepository.findById(newTask.getId());
		assertThat(actual).isNotNull();
	}
	
	
	@Test
	public void testDeleteTaskById() {	
		Task newTask = new Task();
		newTask.setTaskName("Task Delete Test");
		newTask.setTaskDescription("Test Delete By Id");
		newTask.setDateSubmit(new Date());
		newTask.setPriority((short) 5);
		taskRepository.save(newTask);
		boolean updt = taskRepository.deleteById(newTask.getId());
		assertThat(updt).isTrue();
	}
	
	@Test
	public void testUpdateTask() {
		
		Task newTask = new Task();
		newTask.setTaskName("Task Delete Test");
		newTask.setTaskDescription("Test Delete By Id");
		newTask.setDateSubmit(new Date());
		newTask.setPriority((short) 5);
		taskRepository.save(newTask);
		
		boolean updt = taskRepository.update(newTask);
		assertThat(updt).isTrue();
		
	}
	
}
