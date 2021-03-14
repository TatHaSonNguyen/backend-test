package com.example.employeesmanagement.repositories;

import com.example.employeesmanagement.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAllByAge(int age, Pageable pageable);

    Page<Employee> findAllByEducationLevel(int id, Pageable pageable);

    Page<Employee> findAllByOccupation(int id, Pageable pageable);
}
