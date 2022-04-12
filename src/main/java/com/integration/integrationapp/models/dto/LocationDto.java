package com.integration.integrationapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LocationDto {
    private String address;
    private String city;
    private String name;
}
