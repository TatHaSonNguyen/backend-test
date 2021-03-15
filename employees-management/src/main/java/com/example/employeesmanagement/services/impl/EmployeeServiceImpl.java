package com.example.employeesmanagement.services.impl;

import com.example.employeesmanagement.repositories.EmployeeRepository;
import com.example.employeesmanagement.services.EmployeeService;
import com.example.employeesmanagement.services.dto.EmployeeDTO;
import com.example.employeesmanagement.services.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implement transaction to get data from DB
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    private final EmployeeMapper employeeMapper;

    /**
     * @param employeeRepository
     * @param employeeMapper
     */
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    /**
     * @param pageable the pageable property to be defined in request.
     * @return  response data mapping response model
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllEmployees(Pageable pageable) {
        log.debug("Request to get all Employees");
        Page<EmployeeDTO> pageEmployees= employeeRepository.findAll(pageable).map(employeeMapper::toDto);
        return pageEmployees;
    }

    /**
     * @param age      the age of employee
     * @param pageable the pageable property to be defined in request.
     * @return response data mapping response model
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllByAge(int age, Pageable pageable) {
        log.debug("Request to get all Employees based on the age is defined");
        Page<EmployeeDTO> pageEmployees= employeeRepository.findAllByAge(age,pageable).map(employeeMapper::toDto);
        return pageEmployees;
    }

    /**
     * @param id       education level id
     * @param pageable the pageable property to be defined in request.
     * @return response data mapping response model
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllByEducationLevel(int id, Pageable pageable) {
        log.debug("Request to get all Employees based on the education field is defined");
        Page<EmployeeDTO> pageEmployees= employeeRepository.findAllByEducationLevel_Id(id,pageable).map(employeeMapper::toDto);
        return pageEmployees;
    }

    /**
     * @param id       occupation id
     * @param pageable the pageable property to be defined in request.
     * @return response data mapping response model
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllByOccupation(int id, Pageable pageable) {
        log.debug("Request to get all Employees based on the occupation field is defined");
        Page<EmployeeDTO> pageEmployees= employeeRepository.findAllByOccupation_Id(id,pageable).map(employeeMapper::toDto);
        return pageEmployees;
    }

}
