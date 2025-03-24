package org.axzarian.footballtestapp.converter;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.junit.jupiter.api.Test;

class ArbiterConverterTest {

    ArbiterConverter arbiterConverter = new ArbiterConverter();

    @Test
    void testToDto() {
        final var arbiter = Arbiter.builder()
                                   .id(10L)
                                   .firstName("Wolfgang")
                                   .lastName("Berlin")
                                   .birthDate(LocalDate.of(1990, 1, 1))
                                   .build();

        //
        final var result = arbiterConverter.toDto(arbiter);
        //

        assertThat(result).usingRecursiveComparison().isEqualTo(arbiter);

    }

    @Test
    void testToEntity() {
        final var dto = CreateArbiterDto.builder()
                                        .id(10L)
                                        .firstName("Wolfgang")
                                        .lastName("Berlin")
                                        .birthDate(LocalDate.of(1990, 1, 1))
                                        .build();

        //
        final var result = arbiterConverter.toEntity(dto);
        //

        assertThat(result).usingRecursiveComparison().isEqualTo(dto);
    }
}