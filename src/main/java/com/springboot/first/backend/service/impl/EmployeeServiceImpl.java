package com.springboot.first.backend.service.impl;

import org.springframework.stereotype.Service;
import net.javaguides.springboot.EmployeeRepository;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	
	private EmployeeRepository employeeRepository;
	private Long id;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	} 

	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

		@Override
		public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();

		}

	public Employee getEmployeeById(long, id) {
	
	//	 TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
	}

