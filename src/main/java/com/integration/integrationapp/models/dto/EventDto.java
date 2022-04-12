package com.integration.integrationapp.models.dto;

import com.integration.integrationapp.models.enums.EventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventDto {
    private long id;
    private CategoryDto category;
    private String name;
    private LocationDto place;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private List<UserDto> users;
    private List<BadgeDto> badges;
    private EventStatus status;
    private UserDto host;
    private List<String> tags;
}
