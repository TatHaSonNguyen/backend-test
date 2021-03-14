package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Sex;
import com.example.employeesmanagement.services.dto.SexDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SexMapper {

    SexDTO toDto(Sex sex);

    Sex toEntity(SexDTO sexDTO);

    default Sex fromId(int id) {
        if (id == 0) {
            return null;
        }
        Sex sex = new Sex();
        sex.setId(id);
        return sex;
    }

}
