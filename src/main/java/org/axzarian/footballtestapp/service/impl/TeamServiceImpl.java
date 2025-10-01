package org.axzarian.footballtestapp.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.converter.TeamConverter;
import org.axzarian.footballtestapp.dto.TeamDto;
import org.axzarian.footballtestapp.entity.Team;
import org.axzarian.footballtestapp.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.repository.PlayerResitory;
import org.axzarian.footballtestapp.repository.TeamRepository;
import org.axzarian.footballtestapp.service.TeamService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerResitory playerResitory;
    private final TeamConverter  teamConverter;

    @Override
    public void create(TeamDto teamDto) {

        playerResitory.findById(teamDto.captainId())
                      .map(p -> Team.builder()
                                    .title(teamDto.title())
                                    .captain(p)
                                    .build())
                      .map(teamRepository::save)
                      .orElseThrow(() -> new EntityDoesNotExist("There is no player with id " + teamDto.captainId()));
    }

    @Override
    public TeamDto findById(Long id) {

        return teamRepository
            .findById(id)
            .map(t -> TeamDto.builder()
                             .id(t.getId())
                             .title(t.getTitle())
                             .captainId(t.getCaptain().getId()).build())
            .orElseThrow(() -> new EntityDoesNotExist("There is no team with id: %s ".formatted(id)));
    }

    @Override
    public List<TeamDto> findAll() {
        final var teams = teamRepository.findAll();
        return teams.stream().map(teamConverter::toDto).toList();
    }


}
