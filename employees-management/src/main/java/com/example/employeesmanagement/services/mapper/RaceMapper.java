package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Race;
import com.example.employeesmanagement.services.dto.RaceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RaceMapper {

    RaceDTO toDto(Race race);

    Race toEntity(RaceDTO raceDTO);

    default Race fromId(int id) {
        if (id == 0) {
            return null;
        }
        Race race = new Race();
        race.setId(id);
        return race;
    }

}
