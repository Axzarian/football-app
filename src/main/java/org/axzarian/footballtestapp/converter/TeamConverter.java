package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.dto.TeamDto;
import org.axzarian.footballtestapp.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    public TeamDto toDto(Team team) {
        return TeamDto.builder()
                      .id(team.getId())
                      .title(team.getTitle())
                      .build();
    }
}
