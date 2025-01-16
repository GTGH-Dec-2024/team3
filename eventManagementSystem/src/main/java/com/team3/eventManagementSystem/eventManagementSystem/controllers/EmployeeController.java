package com.team3.eventManagementSystem.eventManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team3.eventManagementSystem.eventManagementSystem.models.Employee;
import com.team3.eventManagementSystem.eventManagementSystem.models.Event;
import com.team3.eventManagementSystem.eventManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	// Works for adding 1 or more Employees
	@PostMapping("/addEmployee")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return employeeService.addManyEmployees(employees);
	}

	@PutMapping("/updateEmployee")
	public List<Employee> updateEmployee(@RequestParam Integer id, @RequestParam(required = false) String newName,
			@RequestParam(required = false) String newSurname, @RequestParam(required = false) String newEmail) {
		return employeeService.updateEmployee(id, newName, newSurname, newEmail);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/deleteEmployee") 
	public List<Employee> deleteEmployee(@RequestParam Integer employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@GetMapping("/getDeletedList")
	public List<Event> getDeletedList(@RequestBody Integer employeeId){
		return employeeService.getDeletedList(employeeId);
	}
}