package org.axzarian.footballtestapp.dto;

import java.time.LocalDate;
import lombok.Builder;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.entity.Season;
import org.axzarian.footballtestapp.entity.Team;
import org.axzarian.footballtestapp.entity.enums.GameResult;

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
