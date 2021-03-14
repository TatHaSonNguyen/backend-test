package com.example.employeesmanagement.services;

import com.example.employeesmanagement.services.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {


    /**
     * Get all the employees.
     *
     * @param pageable the pageable property to be defined in request.
     * @return the list of entities.
     */
    Page<EmployeeDTO> findAllEmployees(Pageable pageable);

    /**
     * Get all the employees.
     * @param age the age of employee
     * @param pageable the pageable property to be defined in request.
     * @return the list of entities.
     */
    Page<EmployeeDTO> findAllByAge(int age, Pageable pageable);

    /**
     * Get all the employees.
     * @param id education level id
     * @param pageable the pageable property to be defined in request.
     * @return the list of entities.
     */
    Page<EmployeeDTO> findAllByEducationLevel(int id, Pageable pageable);

    /**
     * Get all the employees.
     * @param id occupation id
     * @param pageable the pageable property to be defined in request.
     * @return the list of entities.
     */
    Page<EmployeeDTO> findAllByOccupation(int id, Pageable pageable);

    /**
     * Get the "id" employee.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmployeeDTO> findOne(int id);

}

