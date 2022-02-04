package com.springboot.first.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	private	@Column(name="first_name",nullable=false) 
	private String startName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="E-mail", nullable=false)
	private String email;
	
	
}
