package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Workclass;
import com.example.employeesmanagement.services.dto.WorkclassDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkClassMapper {

    WorkclassDTO toDto(Workclass workclass);

    Workclass toEntity(WorkclassDTO workClassDTO);

    default Workclass fromId(int id) {
        if (id == 0) {
            return null;
        }
        Workclass workClasses = new Workclass();
        workClasses.setId(id);
        return workClasses;
    }

}
