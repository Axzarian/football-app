package org.axzarian.footballtestapp.core.arbiter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record ArbiterDto(

    Long id,

    @NotBlank(message = "First name can not be empty")
    String firstName,

    @NotBlank(message = "Last name can not be empty")
    String lastName,

    @NotNull(message = "Birthdate is mandatory")
    LocalDate birthDate
) {
}
