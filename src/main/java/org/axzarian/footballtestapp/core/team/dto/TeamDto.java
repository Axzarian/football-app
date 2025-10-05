package org.axzarian.footballtestapp.core.team.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TeamDto(

    Long id,

    @NotBlank
    String title
) {
}
