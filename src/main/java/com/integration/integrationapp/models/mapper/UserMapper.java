package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.BadgeDto;
import com.integration.integrationapp.models.dto.UserDto;
import com.integration.integrationapp.models.entity.Badge;
import com.integration.integrationapp.models.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final BadgeMapper badgeMapper;

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
            builder.badges(new HashSet<>(getListOfBadges(userDto)));
        }

        return builder.build();
    }

    public UserDto entityToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto.UserDtoBuilder builderDto = UserDto.builder();

        if (Objects.nonNull(user.getId())) {
            builderDto.id(user.getId());
        }
        if (Objects.nonNull(user.getRole())) {
            builderDto.role("user");
        }
        if (Objects.nonNull(user.getName())) {
            builderDto.name(user.getName());
        }
        if (Objects.nonNull(user.getEmail())) {
            builderDto.email(user.getEmail());
        }
        if (Objects.nonNull(user.getPassword())) {
            builderDto.password(user.getPassword());
        }
        if (Objects.nonNull(user.getBadges())) {
            builderDto.badges(new HashSet<>(getListOfBadgesDto(user)));
            builderDto.points(user.getBadges().stream()
                    .mapToInt(Badge::getPoints).sum());
        }


        return builderDto.build();
    }

    private List<Badge> getListOfBadges(UserDto userDto) {
        return userDto.getBadges().stream()
                .map(badge -> badgeMapper.dtoToEntity(badge))
                .collect(Collectors.toList());
    }

    private List<BadgeDto> getListOfBadgesDto(User user) {
        return user.getBadges().stream()
                .map(badge -> badgeMapper.entityToDto(badge))
                .collect(Collectors.toList());
    }
}
