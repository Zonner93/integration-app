package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.BadgeDto;
import com.integration.integrationapp.models.dto.CategoryDto;
import com.integration.integrationapp.models.dto.EventDto;
import com.integration.integrationapp.models.dto.UserDto;
import com.integration.integrationapp.models.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventMapper {

    private final CategoryMapper categoryMapper;
    private final LocationMapper locationMapper;
    private final UserMapper userMapper;
    private final BadgeMapper badgeMapper;

    private List<CategoryDto> getListOfCategoriesDto(Event event) {
        return event.getCategories().stream()
                .map(categoryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private List<Category> getListOfCategories(EventDto event) {
        return event.getCategoriesDto().stream()
                .map(categoryMapper::dtoToEntity)
                .collect(Collectors.toList());
    }

    private List<UserDto> getListOfUsersDto(Event event) {
        return event.getParticipants().stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private List<User> getListOfUsers(EventDto event) {
        return event.getUsers().stream()
                .map(userMapper::dtoToEntity)
                .collect(Collectors.toList());
    }

    private List<BadgeDto> getListOfBadgesDto(Event event) {
        return event.getRewards().stream()
                .map(badgeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    private List<Badge> getListOfBadges(EventDto event) {
        return event.getBadges().stream()
                .map(badgeMapper::dtoToEntity)
                .collect(Collectors.toList());
    }


    public Event dtoToEntity(EventDto eventDto) {
        if (eventDto == null) {
            return null;
        }
        Event.EventBuilder builder = Event.builder();

        if (Objects.nonNull(eventDto.getId())) {
            builder.id(eventDto.getId());
        }
        if (Objects.nonNull(eventDto.getCategoriesDto())) {
            builder.categories(new HashSet<>(getListOfCategories(eventDto)));
        }
        if (Objects.nonNull(eventDto.getName())) {
            builder.eventName(eventDto.getName());
        }
        if (Objects.nonNull(eventDto.getPlace())) {
            builder.location(locationMapper.dtoToEntity(eventDto.getPlace()));
        }
        if (Objects.nonNull(eventDto.getDescription())) {
            builder.description(eventDto.getDescription());
        }
        if (Objects.nonNull(eventDto.getDateStart())) {
            builder.dateStart(eventDto.getDateStart());
        }
        if (Objects.nonNull(eventDto.getDateEnd())) {
            builder.dateEnd(eventDto.getDateEnd());
        }
        if (Objects.nonNull(eventDto.getUsers())) {
            builder.participants(new HashSet<>(getListOfUsers(eventDto)));
        }
        if (Objects.nonNull(eventDto.getBadges())) {
            builder.rewards(new HashSet<>(getListOfBadges(eventDto)));
        }
        if (Objects.nonNull(eventDto.getStatus())) {
            builder.status(eventDto.getStatus());
        }
        if (Objects.nonNull(eventDto.getHost())) {
            builder.host(userMapper.dtoToEntity(eventDto.getHost()));
        }

        return builder.build();

    }

    public EventDto entityToDto(Event event) {
        if (event == null) {
            return null;
        }
        EventDto.EventDtoBuilder builderDto = EventDto.builder();

        if (Objects.nonNull(event.getId())) {
            builderDto.id(event.getId());
        }
        if (Objects.nonNull(event.getCategories())) {
            builderDto.categoriesDto(
                    new HashSet<>(getListOfCategoriesDto(event))
            );
        }
        if (Objects.nonNull(event.getEventName())) {
            builderDto.name(event.getEventName());
        }
        if (Objects.nonNull(event.getLocation())) {
            builderDto.place(locationMapper.entityToDto(event.getLocation()));
        }
        if (Objects.nonNull(event.getDescription())) {
            builderDto.description(event.getDescription());
        }
        if (Objects.nonNull(event.getDateStart())) {
            builderDto.dateStart(event.getDateStart());
        }
        if (Objects.nonNull(event.getDateEnd())) {
            builderDto.dateEnd(event.getDateEnd());
        }
        if (Objects.nonNull(event.getParticipants())) {
            builderDto.users(getListOfUsersDto(event));
        }
        if (Objects.nonNull(event.getRewards())) {
            builderDto.badges(getListOfBadgesDto(event));
        }
        if (Objects.nonNull(event.getStatus())) {
            builderDto.status(event.getStatus());
        }
        if (Objects.nonNull(event.getHost())) {
            builderDto.host(userMapper.entityToDto(event.getHost()));
        }
        if (Objects.nonNull(event.getTags())) {
            builderDto.tags(event
                            .getTags()
                            .stream()
                            .map(EventTag::getName)
                            .collect(Collectors.toList())
            );
        }
        return builderDto.build();

    }


}