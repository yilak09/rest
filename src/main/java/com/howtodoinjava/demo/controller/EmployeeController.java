package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

		if (isInFuture(yearOfBirth)) {
			return new ResponseEntity<>(
					"Year of birth cannot be in the future",
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(
				"Your age is " + calculateAge(yearOfBirth),
				HttpStatus.OK);
	}

	private boolean isInFuture(int yearOfBirth) {
		boolean isInfuture =false;
		if(yearOfBirth>2019){
			isInfuture =false;

		}else{
			isInfuture=true;
		}
		return isInfuture;
	}

	int calculateAge(int yearOfBirth){
		return 2019-yearOfBirth;
	}

	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom-Header", "foo");

		return new ResponseEntity<>(
				"Custom header set", headers, HttpStatus.OK);
	}
}
