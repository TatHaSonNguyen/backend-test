package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Country;
import com.example.employeesmanagement.entities.EducationLevel;
import com.example.employeesmanagement.services.dto.EducationLevelDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface EducationLevelMapper {

    EducationLevelDTO toDto(EducationLevel educationLevel);

    EducationLevel toEntity(EducationLevelDTO educationLevelDTO);

    default EducationLevel fromId(int id) {
        if (id == 0) {
            return null;
        }
        EducationLevel educationLevel = new EducationLevel();
        educationLevel.setId(id);
        return educationLevel;
    }
}
