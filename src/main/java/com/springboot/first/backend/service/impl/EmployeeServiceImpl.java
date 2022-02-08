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
	public Employee getEmployeeById(long id) {
    	
    	return (employeeRepository.findById(id)).orElseThrow(()->
    				new ResourceNotFoundException("Employee","Id",id));
    }
	public Employee updateEmployee(Employee employee,long id) {
		//we need to check whether employee with given id is existing database or not
		Employee existingEmployee = (employeeRepository.findById(id)).orElseThrow(()->
				new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to database
		Employee employeeRespository= employeeRepository.save(existingEmployee);
		
		return null;
	}
	public void deleteEmployee(long id)
	{
		//check whether employee id is in DB existing or not
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}
}