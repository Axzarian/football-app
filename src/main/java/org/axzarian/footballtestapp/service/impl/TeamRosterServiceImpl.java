package org.axzarian.footballtestapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.TeamRosterDto;
import org.axzarian.footballtestapp.entity.TeamRoster;
import org.axzarian.footballtestapp.repository.PlayerResitory;
import org.axzarian.footballtestapp.repository.SeasonRepository;
import org.axzarian.footballtestapp.repository.TeamRepository;
import org.axzarian.footballtestapp.repository.TeamRosterRepository;
import org.axzarian.footballtestapp.service.TeamRosterService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamRosterServiceImpl implements TeamRosterService {

    private final TeamRosterRepository teamRosterRepository;
    private final PlayerResitory       playerResitory;
    private final TeamRepository       teamRepository;
    private final SeasonRepository     seasonRepository;


    @Override
    public void create(TeamRosterDto teamRosterDto) {

        final var seasonById = seasonRepository.findById(teamRosterDto.seasonId());
        final var teamById   = teamRepository.findById(teamRosterDto.teamId());
        final var playerById = playerResitory.findById(teamRosterDto.playerId());

        if (seasonById.isPresent() && teamById.isPresent() && playerById.isPresent()) {

            final var teamRoster = TeamRoster.builder()
                                             .team(teamById.get())
                                             .player(playerById.get())
                                             .season(seasonById.get())
                                             .build();

            teamRosterRepository.save(teamRoster);
        }


    }
}
