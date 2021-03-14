package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.MaritalStatus;
import com.example.employeesmanagement.services.dto.MaritalStatusDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaritalStatusMapper {

    MaritalStatusDTO toDto(MaritalStatus maritalStatus);

    MaritalStatus toEntity(MaritalStatusDTO maritalStatusDTO);

    default MaritalStatus fromId(int id) {
        if (id == 0) {
            return null;
        }
        MaritalStatus maritalStatus = new MaritalStatus();
        maritalStatus.setId(id);
        return maritalStatus;
    }

}
