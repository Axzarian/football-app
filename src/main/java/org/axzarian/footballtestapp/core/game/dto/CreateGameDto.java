package org.axzarian.footballtestapp.core.game.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Builder;
import org.axzarian.footballtestapp.core.game.enums.GameResult;

@Builder
public record CreateGameDto(
    Long id,

    @NotNull(message = "You have to provide season id")
    Long seasonId,

    LocalDate gameDate,

    @NotNull(message = "You have to provide arbiter id")
    Long arbiterId,

    @NotNull(message = "You have to provide home team id")
    Long homeTeamId,

    @NotNull(message = "You have to provide away team id")
    Long awayTeamId,


    Integer homeTeamGoals,
    Integer awayTeamGoals,
    Integer yellowCards,
    Integer redCards,
    boolean isFinished,
    GameResult result

) {
}
