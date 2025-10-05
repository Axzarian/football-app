package org.axzarian.footballtestapp.core.team_roster.service;

import java.util.List;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.team_roster.dto.SeasonTeamRosterDto;
import org.axzarian.footballtestapp.core.team_roster.dto.TeamRosterDto;

public interface TeamRosterService {
    void create (TeamRosterDto teamRosterDto);

    List<PlayerDto> getBySeasonAndTeam(Long seasonId, Long teamId);

    SeasonTeamRosterDto getBySeasonAndTeamTest(Long seasonId, Long teamId);
}
