package com.employer.crud.exployercrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employer.crud.exployercrud.model.EmployeeModel;
@Service
public interface EmployeeService {
	List<EmployeeModel>getAllEmployees();
	void saveEmployee(EmployeeModel employee);
	
	EmployeeModel getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
