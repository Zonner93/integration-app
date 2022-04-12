package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.LocationDto;
import com.integration.integrationapp.models.entity.Location;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LocationMapper {

    public Location dtoToEntity(LocationDto locationDto) {
        if (locationDto == null) {
            return null;
        }
        Location.LocationBuilder builder = Location.builder();

        if (Objects.nonNull(locationDto.getName())) {
            builder.locationName(locationDto.getName());
        }
        if (Objects.nonNull(locationDto.getCity())) {
            builder.city(locationDto.getCity());
        }
        if (Objects.nonNull(locationDto.getAddress())) {
            builder.city(locationDto.getAddress());
        }
        return builder.build();
    }

    public LocationDto entityToDto(Location location) {
        if (location == null) {
            return null;
        }
        LocationDto.LocationDtoBuilder builderDto = LocationDto.builder();

        if (Objects.nonNull(location.getLocationName())) {
            builderDto.name(location.getLocationName());
        }
        if (Objects.nonNull(location.getCity())) {
            builderDto.city(location.getCity());
        }
        if (Objects.nonNull(location.getStreet())) {
            builderDto.address(location.getStreet());
        }
        return builderDto.build();
    }

}
