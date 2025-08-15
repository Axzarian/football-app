package org.axzarian.footballtestapp.dto;

import jakarta.validation.constraints.NotNull;

public record TeamRosterDto(

    Long id,

    @NotNull
    Long seasonId,

    @NotNull
    Long teamId,

    @NotNull
    Long playerId
) {
}
