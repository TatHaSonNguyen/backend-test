package com.example.employeesmanagement.repositories;

import com.example.employeesmanagement.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Define actions to implement communicate for get data from DB and mapping with DB model
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @param age
     * @param pageable
     * @return employees with the respective age
     */
    Page<Employee> findAllByAge(int age, Pageable pageable);


    /**
     * @param id
     * @param pageable
     * @return employees with the respective Education Level by id
     */
    Page<Employee> findAllByEducationLevel_Id(int id, Pageable pageable);

    /**
     * @param id
     * @param pageable
     * @return employees with the respective Education Level by id
     */
    Page<Employee> findAllByOccupation_Id(int id, Pageable pageable);
}
