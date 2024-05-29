package com.pennant.boot.mvc.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pennant.boot.mvc.model.Employee;
import com.pennant.boot.mvc.service.EmpService;

@Controller
public class EmployeeController {
	
	EmpService empService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	public EmployeeController(EmpService es) {
		empService=es;
	}

	/**
	 * selects the employees list view to render by returning its name.
	 */
	@GetMapping(value = "/emplist")
	public String getAllEmployees(Model model) {
        logger.info("Handling /emplist request");

		//get all employees from service
        logger.info("about to invoke service method");
        System.out.println("about to invoke service method");
        
		List<Employee> empList=empService.findAll();
		
        logger.info("Got emplist from service");
        System.out.println("got emplist from service");
        System.out.println(empList.toString());
		
		//set it to the model
		model.addAttribute("elist",empList);
		
        logger.info("about to call logical view");
        System.out.println("about to call logical view");
        
		//call the view
		return "emplist";
	}
	
	/*
	
	@RequestMapping(value = "/addnewemp", method = RequestMethod.GET)
	public String addNewEmployee(Model model) {
		System.out.println("Add New Emp JSP Requested");
		return "newemp";
	}

	@RequestMapping(value = "/savenewemp", method = RequestMethod.POST)
	public String saveNewEmployee(@Validated Employee emp, Model model) {
		System.out.println("Save New Employee Page Requested");
		//get all employees from DAO
		boolean b=edao.createEmployee(emp);
		
		//set it to the model
		if (b) {
			model.addAttribute("emp",emp);
		}
		return "saveempsuccess";
	}
	*/
}
