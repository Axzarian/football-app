package org.axzarian.footballtestapp.service;

import java.util.List;
import org.axzarian.footballtestapp.dto.PlayerDto;
import org.axzarian.footballtestapp.dto.SeasonTeamRosterDto;
import org.axzarian.footballtestapp.dto.TeamRosterDto;

public interface TeamRosterService {
    void create (TeamRosterDto teamRosterDto);

    List<PlayerDto> getBySeasonAndTeam(Long seasonId, Long teamId);

    SeasonTeamRosterDto getBySeasonAndTeamTest(Long seasonId, Long teamId);
}
