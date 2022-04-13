package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.BadgeDto;
import com.integration.integrationapp.models.dto.CategoryDto;
import com.integration.integrationapp.models.dto.EventDto;
import com.integration.integrationapp.models.dto.UserDto;
import com.integration.integrationapp.models.entity.Badge;
import com.integration.integrationapp.models.entity.Event;
import com.integration.integrationapp.models.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventMapper {


    private List<CategoryDto> getListOfCategoriesDto(Event event) {
        return event.getCategories().stream()
                .map(badge -> badgeMapper.entityToDto(badge))
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
        if (Objects.nonNull(eventDto.getCategory())) {
            builder.categories(eventDto.getCategory());
        }
        if (Objects.nonNull(eventDto.getName())) {
            builder.eventName(eventDto.getName());
        }
        if (Objects.nonNull(eventDto.getPlace())) {
            builder.location(eventDto.getPlace());
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
            builder.participants(eventDto.getUsers());
        }
        if (Objects.nonNull(eventDto.getBadges())) {
            builder.rewards(eventDto.getBadges());
        }
        if (Objects.nonNull(eventDto.getStatus())) {
            builder.status(eventDto.getStatus());
        }
        if (Objects.nonNull(eventDto.getHost())) {
            builder.host(eventDto.getHost());
        }
        if (Objects.nonNull(eventDto.getTags())) {
            builder.tags(eventDto.getTags());
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
            builderDto.category(event.getCategories());
        }
        if (Objects.nonNull(event.getEventName())) {
            builderDto.name(event.getEventName());
        }
        if (Objects.nonNull(event.getLocation())) {
            builderDto.place(event.getLocation());
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
            builderDto.users(event.getParticipants());
        }
        if (Objects.nonNull(event.getRewards())) {
            builderDto.badges(event.getRewards());
        }
        if (Objects.nonNull(event.getStatus())) {
            builderDto.status(event.getStatus());
        }
        if (Objects.nonNull(event.getHost())) {
            builderDto.host(event.getHost());
        }
        if (Objects.nonNull(event.getTags())) {
            builderDto.tags(event.getTags());
        }
        return builderDto.build();

    }


}