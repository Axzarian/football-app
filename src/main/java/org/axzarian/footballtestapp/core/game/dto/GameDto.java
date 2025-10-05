package org.axzarian.footballtestapp.core.game.dto;

import java.time.LocalDate;
import lombok.Builder;
import org.axzarian.footballtestapp.core.arbiter.Arbiter;
import org.axzarian.footballtestapp.core.season.Season;
import org.axzarian.footballtestapp.core.team.Team;
import org.axzarian.footballtestapp.core.game.GameResult;

@Builder
public record GameDto(
    Long id,
    Season season,
    LocalDate gameDate,
    Arbiter arbiter,
    Team homeTeam,
    Team awayTeam,
    Integer homeTeamGoals,
    Integer awayTeamGoals,
    Integer yellowCards,
    Integer redCards,
    boolean isFinished,
    GameResult result
) {}
