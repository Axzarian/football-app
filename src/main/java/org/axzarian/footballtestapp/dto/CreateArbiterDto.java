package org.axzarian.footballtestapp.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record CreateArbiterDto(

    Long id,

    @NotBlank(message = "First name can not be empty")
    String firstName,

    @NotBlank(message = "Last name can not be empty")
    String lastName,

    LocalDate birthDate
) {
}
