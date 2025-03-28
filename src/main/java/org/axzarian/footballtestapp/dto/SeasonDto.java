package org.axzarian.footballtestapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record SeasonDto(

    Long id,

    @NotBlank
    String title,

    @NotNull
    LocalDate startDate,

    @NotNull
    LocalDate endDate
) {
}
