package com.integration.integrationapp.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long id;
    private String role;
    private String name;
    private String email;
    private String password;
    private BadgeDto badges;
    private int points;
}
