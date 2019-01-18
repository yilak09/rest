package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.howtodoinjava.demo.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("/")
    public List<Employee> getEmployees() 
    {
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return employeesList;
    }

	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@GetMapping("/age")
	ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
		System.out.println("yearOfBirth"+yearOfBirth);

		if (empService.isInFuture(yearOfBirth)) {
			return new ResponseEntity<>(
					"Year of birth cannot be in the future",
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(
				"Your age is " + empService.calculateAge(yearOfBirth),
				HttpStatus.OK);
	}



	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");

		return new ResponseEntity<>(
				"Custom header set", headers, HttpStatus.OK);
	}
}
