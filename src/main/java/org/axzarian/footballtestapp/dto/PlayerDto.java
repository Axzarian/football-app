package org.axzarian.footballtestapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Builder;
import org.axzarian.footballtestapp.entity.enums.Leg;
import org.axzarian.footballtestapp.entity.enums.Position;

@Builder
public record PlayerDto(

    Long id,

    @NotBlank(message = "First name can not be empty")
    String firstName,

    @NotBlank(message = "Last name can not be empty")
    String lastName,

    @NotNull(message = "Birthdate is mandatory")
    LocalDate birthDate,

    @NotNull(message = "Position is mandatory")
    Position position,

    @NotNull(message = "Leg is mandatory")
    Leg leg,

    @NotNull(message = "Set is player a captain")
    boolean isCaptain,

    @Min(10)
    @Max(100)
    @NotNull
    Integer passing,

    @Min(10)
    @Max(100)
    @NotNull
    Integer shooting,

    @Min(10)
    @Max(100)
    @NotNull
    Integer ballControl
) {
}
