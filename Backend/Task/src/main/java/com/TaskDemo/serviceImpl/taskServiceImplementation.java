package com.TaskDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskDemo.Entity.Task;
import com.TaskDemo.Repository.TaskRepository;
import com.TaskDemo.service.taskService;

@Service
public class taskServiceImplementation implements taskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void createTask(Task task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);		
	}

	@Override
	public boolean updateTask(Long id, Task task) {
		// TODO Auto-generated method stub
		boolean rowsUpdate = taskRepository.update(task);
		return rowsUpdate;	
	}

	@Override
	public boolean deleteTask(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.deleteById(id);
	}

	@Override
	public List<Task> findAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAllTasks();
	}

	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

}
