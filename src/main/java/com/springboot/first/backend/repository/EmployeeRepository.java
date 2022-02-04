package com.springboot.first.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {

	com.springboot.first.backend.service.impl.Employee save(
			com.springboot.first.backend.service.impl.Employee employee);

	
}
