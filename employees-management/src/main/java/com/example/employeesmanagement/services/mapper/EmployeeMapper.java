package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Employee;
import com.example.employeesmanagement.entities.Workclass;
import com.example.employeesmanagement.services.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapping and convert between DTOObject and EntityObject
 * DTOObject: EmployeeDTO
 * EntityObject: Employee
 */
@Mapper(componentModel = "spring", uses = {CountryMapper.class, EducationLevelMapper.class, MaritalStatusMapper.class, OccupationMapper.class, RaceMapper.class,RelationshipMapper.class,SexMapper.class, Workclass.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee>{

    @Mapping(source = "workclass.id", target = "workclass_id")
    @Mapping(source = "workclass.name", target = "workclass_name")
    @Mapping(source = "educationLevel.id", target = "education_level_id")
    @Mapping(source = "educationLevel.name", target = "education_level_name")
    @Mapping(source = "maritalStatus.id", target = "marital_status_id")
    @Mapping(source = "maritalStatus.name", target = "marital_status_name")
    @Mapping(source = "occupation.id", target = "occupation_id")
    @Mapping(source = "occupation.name", target = "occupation_name")
    @Mapping(source = "relationship.id", target = "relationship_id")
    @Mapping(source = "relationship.name", target = "relationship_name")
    @Mapping(source = "race.id", target = "race_id")
    @Mapping(source = "race.name", target = "race_name")
    @Mapping(source = "sex.id", target = "sex_id")
    @Mapping(source = "sex.name", target = "sex_name")
    @Mapping(source = "country.id", target = "country_id")
    @Mapping(source = "country.name", target = "country_name")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "workclass_id", target = "workclass.id")
    @Mapping(source = "education_level_id", target = "educationLevel")
    @Mapping(source = "marital_status_id", target = "maritalStatus")
    @Mapping(source = "occupation_id", target = "occupation")
    @Mapping(source = "relationship_id", target = "relationship")
    @Mapping(source = "race_id", target = "race")
    @Mapping(source = "sex_id", target = "sex")
    @Mapping(source = "country_id", target = "country")
    Employee toEntity(EmployeeDTO employeeDTO);

    default Employee fromId(int id) {
        if (id == 0) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
