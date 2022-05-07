package com.employer.crud.exployercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employer.crud.exployercrud.model.EmployeeModel;
import com.employer.crud.exployercrud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data
		EmployeeModel employee = new EmployeeModel();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable (value = "id")long id, Model model) {
		EmployeeModel employee = employeeService.getEmployeeById(id);
		//Set employee as a model attribute to pre-populate the form
		model.addAttribute("employee",employee);
		return "update_employee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")EmployeeModel employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id")long id) {
		
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
