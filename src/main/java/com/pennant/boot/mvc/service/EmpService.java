package com.pennant.boot.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pennant.boot.mvc.repository.EmpRepository;
import com.pennant.boot.mvc.model.Employee;

@Service
public class EmpService {
	
	 @Autowired
	 private EmpRepository empRepository;

	  public List<Employee> findAll(){
	        System.out.println("about to invoke repository method");
	    	return empRepository.findAll();
	    }
}
