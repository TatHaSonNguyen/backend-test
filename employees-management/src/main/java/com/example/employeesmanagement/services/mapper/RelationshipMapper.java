package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Relationship;
import com.example.employeesmanagement.services.dto.RelationshipDTO;
import org.mapstruct.Mapper;

/**
 * Mapping and convert between DTOObject and EntityObject
 * DTOObject: RelationshipDTO
 * EntityObject: Relationship
 */
@Mapper(componentModel = "spring")
public interface RelationshipMapper {

    RelationshipDTO toDto(Relationship relationship);

    Relationship toEntity(RelationshipDTO relationshipDTO);

    default Relationship fromId(int id) {
        if (id == 0) {
            return null;
        }
        Relationship relationship = new Relationship();
        relationship.setId(id);
        return relationship;
    }

}
