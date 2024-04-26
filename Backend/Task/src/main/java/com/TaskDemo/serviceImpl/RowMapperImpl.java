package com.TaskDemo.serviceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.TaskDemo.Entity.Task;

public class RowMapperImpl implements RowMapper<Task>{

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Task task = new Task();
		task.setId(rs.getLong(1));
		task.setTaskName(rs.getString(2));
		task.setTaskDescription(rs.getString(3));
		task.setStatus(rs.getShort(4));
		task.setDateSubmit(rs.getDate(5));
		task.setPriority(rs.getShort(6));
		return task;
	}

}
