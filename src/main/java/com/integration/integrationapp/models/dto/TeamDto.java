package com.integration.integrationapp.models.dto;

import com.integration.integrationapp.models.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TeamDto {
    private Set<User> users;
    private String name;
    private String imgUrl;
}
