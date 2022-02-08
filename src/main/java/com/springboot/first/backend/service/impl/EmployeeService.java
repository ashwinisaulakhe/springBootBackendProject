package com.springboot.first.backend.service.impl;

import java.util.List;
import com.springboot.first.backend.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);



}
