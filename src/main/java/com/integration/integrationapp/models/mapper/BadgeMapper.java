package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.BadgeDto;
import com.integration.integrationapp.models.entity.Badge;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BadgeMapper {

    public Badge dtoToEntity(BadgeDto badgeDto) {
        if (badgeDto == null) {
            return null;
        }
        Badge.BadgeBuilder builder = Badge.builder();

        if (Objects.nonNull(badgeDto.getName())) {
            builder.name(badgeDto.getName());
        }
        if (Objects.nonNull(badgeDto.getImgUrl())) {
            builder.imageURL(badgeDto.getImgUrl());
        }
        if (Objects.nonNull(badgeDto.getValue())) {
            builder.value(badgeDto.getValue());
        }
        return builder.build();
    }

    public BadgeDto entityToDto(Badge badge) {
        if (badge == null) {
            return null;
        }
        BadgeDto.BadgeDtoBuilder builderDto = BadgeDto.builder();

        if (Objects.nonNull(badge.getName())) {
            builderDto.name(badge.getName());
        }
        if (Objects.nonNull(badge.getImageURL())) {
            builderDto.imgUrl(badge.getImageURL());
        }
        if (Objects.nonNull(badge.getValue())) {
            builderDto.value(badge.getValue());
        }
        return builderDto.build();
    }
}
