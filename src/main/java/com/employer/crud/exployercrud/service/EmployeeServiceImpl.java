package com.employer.crud.exployercrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employer.crud.exployercrud.model.EmployeeModel;
import com.employer.crud.exployercrud.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<EmployeeModel> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public void saveEmployee(EmployeeModel employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		
		
	}


	@Override
	public EmployeeModel getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<EmployeeModel> optional = employeeRepository.findById(id);
		EmployeeModel employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id : "+id);
			
		}
		return employee;	
	}


	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}

}
