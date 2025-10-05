package org.axzarian.footballtestapp.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.converter.TeamConverter;
import org.axzarian.footballtestapp.dto.TeamDto;
import org.axzarian.footballtestapp.entity.Team;
import org.axzarian.footballtestapp.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.repository.TeamRepository;
import org.axzarian.footballtestapp.service.TeamService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamConverter  teamConverter;

    @Override
    public void create(TeamDto teamDto) {
        final var newTeam = Team.builder()
                                .title(teamDto.title())
                                .build();
        teamRepository.save(newTeam);
    }

    @Override
    public TeamDto findById(Long id) {

        return teamRepository
            .findById(id)
            .map(t -> TeamDto.builder()
                             .id(t.getId())
                             .title(t.getTitle())
                             .build())
            .orElseThrow(() -> new EntityDoesNotExist("There is no team with id: %s ".formatted(id)));
    }

    @Override
    public List<TeamDto> findAll(Pageable pageable) {
        final var teams = teamRepository.findAll(pageable);
        return teams.stream().map(teamConverter::toDto).toList();
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return teamRepository.deleteTeamById(id) > 0;
    }


}
