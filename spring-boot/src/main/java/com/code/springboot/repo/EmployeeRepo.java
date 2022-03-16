package com.code.springboot.repo;

import com.code.springboot.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
// REST resource path - /members
@RepositoryRestResource(path = "members")
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    
}
