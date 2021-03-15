package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Occupation;
import com.example.employeesmanagement.services.dto.OccupationDTO;
import org.mapstruct.Mapper;

/**
 * Mapping and convert between DTOObject and EntityObject
 * DTOObject: OccupationDTO
 * EntityObject: Occupation
 */
@Mapper(componentModel = "spring")
public interface OccupationMapper {

    OccupationDTO toDto(Occupation occupation);

    Occupation toEntity(OccupationDTO occupationDTO);

    default Occupation fromId(int id) {
        if (id == 0) {
            return null;
        }
        Occupation occupation = new Occupation();
        occupation.setId(id);
        return occupation;
    }

}
