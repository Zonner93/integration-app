package com.integration.integrationapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BadgeDto {
    private String name;
    private String imgUrl;
    private int value;
}
