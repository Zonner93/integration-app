package com.integration.integrationapp.models.mapper;

import com.integration.integrationapp.models.dto.TeamDto;
import com.integration.integrationapp.models.entity.Team;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeamMapper {

    public Team dtoToEntity(TeamDto teamDto) {
        if (teamDto == null) {
            return null;
        }
        Team.TeamBuilder builder = Team.builder();

        if (Objects.nonNull(teamDto.getName())) {
            builder.name(teamDto.getName());
        }
        if (Objects.nonNull(teamDto.getImgUrl())) {
            builder.image(teamDto.getImgUrl());
        }
        if (Objects.nonNull(teamDto.getUsers())) {
            builder.users(teamDto.getUsers());
        }
        return builder.build();
    }

    public TeamDto entityToDto(Team team) {

        if (team == null) {
            return null;
        }
        TeamDto.TeamDtoBuilder builderDto = TeamDto.builder();

        if (Objects.nonNull(team.getName())) {
            builderDto.name(team.getName());
        }
        if (Objects.nonNull(team.getImage())) {
            builderDto.imgUrl(team.getImage());
        }
        if (Objects.nonNull(team.getUsers())) {
            builderDto.users(team.getUsers());
        }
        return builderDto.build();

    }
}