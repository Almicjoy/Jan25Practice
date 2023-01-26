package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {
	public void save(Employee e);
	public List<Employee> retrieveEmployees();
	public void deleteById(Integer deletebyId);
	public void updateSalaryById(Integer updateSalaryId, Float salary);
}
