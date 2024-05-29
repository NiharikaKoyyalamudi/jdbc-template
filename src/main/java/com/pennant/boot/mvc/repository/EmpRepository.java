package com.pennant.boot.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pennant.boot.mvc.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
