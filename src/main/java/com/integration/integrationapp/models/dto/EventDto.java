package com.integration.integrationapp.models.dto;

import com.integration.integrationapp.models.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EventDto {
    private long id;
    private Set<CategoryDto> categoriesDto;
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
