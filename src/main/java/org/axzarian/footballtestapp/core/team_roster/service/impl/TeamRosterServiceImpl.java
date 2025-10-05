package org.axzarian.footballtestapp.core.team_roster.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.team_roster.dto.SeasonTeamRosterDto;
import org.axzarian.footballtestapp.core.team_roster.dto.TeamRosterDto;
import org.axzarian.footballtestapp.core.team_roster.TeamRoster;
import org.axzarian.footballtestapp.core.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.core.player.repository.PlayerRepository;
import org.axzarian.footballtestapp.core.season.repository.SeasonRepository;
import org.axzarian.footballtestapp.core.team.repository.TeamRepository;
import org.axzarian.footballtestapp.core.team_roster.repository.TeamRosterRepository;
import org.axzarian.footballtestapp.core.team_roster.service.TeamRosterService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamRosterServiceImpl implements TeamRosterService {

    private final TeamRosterRepository teamRosterRepository;
    private final PlayerRepository     playerRepository;
    private final TeamRepository       teamRepository;
    private final SeasonRepository     seasonRepository;


    @Override
    public void create(TeamRosterDto teamRosterDto) {

        final var seasonById = seasonRepository.findById(teamRosterDto.seasonId());
        final var teamById   = teamRepository.findById(teamRosterDto.teamId());
        final var playerById = playerRepository.findById(teamRosterDto.playerId());

        if (seasonById.isPresent() && teamById.isPresent() && playerById.isPresent()) {

            final var teamRoster = TeamRoster.builder()
                                             .team(teamById.get())
                                             .player(playerById.get())
                                             .season(seasonById.get())
                                             .build();

            teamRosterRepository.save(teamRoster);
            return;
        }
        throw new EntityDoesNotExist("[hg67-js54] One of entity doesn't exist");
    }

    @Override
    public List<PlayerDto> getBySeasonAndTeam(Long seasonId, Long teamId) {
        final var season = seasonRepository.findById(seasonId);
        final var team   = teamRepository.findById(teamId);

        if (season.isPresent() && team.isPresent()) {
            return teamRosterRepository.findPlayersBySeasonAndTeamIds(seasonId, teamId);

        }

        return List.of();
    }

   @Override
    public SeasonTeamRosterDto getBySeasonAndTeamTest(Long seasonId, Long teamId) {
        final var season = seasonRepository.findById(seasonId);
        final var team   = teamRepository.findById(teamId);

        if (season.isPresent() && team.isPresent()) {
            final var players = teamRosterRepository.findPlayersBySeasonAndTeamIds(seasonId, teamId);

            return SeasonTeamRosterDto.builder()
                                      .seasonTitle(season.get().getTitle())
                                      .teamTitle(team.get().getTitle())
                                      .players(players)
                                      .build();
        }

        throw new EntityDoesNotExist("[he82-w9o4] One of entity doesn't exist");

    }
}
