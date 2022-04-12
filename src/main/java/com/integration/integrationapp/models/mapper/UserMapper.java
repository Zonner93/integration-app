package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.TeamDto;
import com.integration.integrationapp.models.dto.UserDto;
import com.integration.integrationapp.models.entity.Team;
import com.integration.integrationapp.models.entity.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {

    public User dtoToEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User.UserBuilder builder = User.builder();

        if (Objects.nonNull(userDto.getId())) {
            builder.id(userDto.getId());
        }
        if (Objects.nonNull(userDto.getRole())) {
            builder.role(userDto.getRole());
        }
        if (Objects.nonNull(userDto.getName())) {
            builder.name(userDto.getName());
        }
        if (Objects.nonNull(userDto.getEmail())) {
            builder.email(userDto.getEmail());
        }
        if (Objects.nonNull(userDto.getPassword())) {
            builder.password(userDto.getPassword());
        }
        if (Objects.nonNull(userDto.getBadges())) {
            builder.badges(userDto.getBadges());
        }
        if (Objects.nonNull(userDto.getPoints())) {
            builder.points(userDto.getPoints());
        }

        return builder.build();
    }

    public UserDto entityToDto(User user) {
        if (user == null) {
            return null;
        }
        User.UserBuilder builder = User.builder();

        if (Objects.nonNull(user.getId())) {
            builder.id(user.getId());
        }
        if (Objects.nonNull(user.getRole())) {
            builder.role(user.getRole());
        }
        if (Objects.nonNull(user.getName())) {
            builder.name(user.getName());
        }
        if (Objects.nonNull(user.getEmail())) {
            builder.email(user.getEmail());
        }
        if (Objects.nonNull(user.getPassword())) {
            builder.password(user.getPassword());
        }
        if (Objects.nonNull(user.getBadges())) {
            builder.badges(user.getBadges());
        }
        if (Objects.nonNull(user.getPoints())) {
            builder.points(user.getPoints());
        }

        return builder.build();
    }
}
