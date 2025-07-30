package com.example.employee_crud.repositories;

import com.example.employee_crud.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//dsa
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
