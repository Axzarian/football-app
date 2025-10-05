package org.axzarian.footballtestapp.core.team.converter;

import org.axzarian.footballtestapp.core.team.dto.TeamDto;
import org.axzarian.footballtestapp.core.team.Team;
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
