package com.example.employeesmanagement.services.mapper;

import com.example.employeesmanagement.entities.Country;
import com.example.employeesmanagement.services.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

/**
 * Mapping and convert between DTOObject and EntityObject
 * DTOObject: CountryDTO
 * EntityObject: Country
 */
@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDTO toDto(Country country);

    Country toEntity(CountryDTO countryDTO);

    default Country fromId(int id) {
        if (id == 0) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }

}
