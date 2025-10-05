package org.axzarian.footballtestapp.dto;

import java.time.LocalDate;
import lombok.Builder;
import org.axzarian.footballtestapp.entity.enums.GameResult;

@Builder
public record CreateGameDto(
    Long id,
    Long seasonId,
    LocalDate gameDate,
    Long arbiterId,
    Long homeTeamId,
    Long awayTeamId,
    Integer homeTeamGoals,
    Integer awayTeamGoals,
    Integer yellowCards,
    Integer redCards,
    boolean isFinished,
    GameResult result

) {
}
