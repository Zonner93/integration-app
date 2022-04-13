package com.integration.integrationapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String role;
    private String name;
    private String email;
    private String password;
    private Set<BadgeDto> badges;
    private int points;
}
