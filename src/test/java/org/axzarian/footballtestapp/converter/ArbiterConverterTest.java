package org.axzarian.footballtestapp.converter;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.axzarian.footballtestapp.core.arbiter.dto.ArbiterDto;
import org.axzarian.footballtestapp.core.arbiter.Arbiter;
import org.axzarian.footballtestapp.core.arbiter.converter.ArbiterConverter;
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
        final var dto = ArbiterDto.builder()
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