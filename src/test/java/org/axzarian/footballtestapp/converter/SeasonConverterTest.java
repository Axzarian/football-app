package org.axzarian.footballtestapp.converter;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.axzarian.footballtestapp.core.season.converter.SeasonConverter;
import org.axzarian.footballtestapp.core.season.dto.SeasonDto;
import org.axzarian.footballtestapp.core.season.Season;
import org.junit.jupiter.api.Test;

class SeasonConverterTest {

    private final SeasonConverter converter = new SeasonConverter();

    @Test
    void toDto() {
        final var entity = Season.builder()
                                 .id(10L)
                                 .title("winter 24/25")
                                 .startDate(LocalDate.of(2024, 1, 1))
                                 .endDate(LocalDate.of(2024, 6, 1))
                                 .build();

        final var dto = SeasonDto.builder()
                                 .id(10L)
                                 .title("winter 24/25")
                                 .startDate(LocalDate.of(2024, 1, 1))
                                 .endDate(LocalDate.of(2024, 6, 1))
                                 .build();

        //
        final var result = converter.toDto(entity);
        //

        assertThat(result).usingRecursiveComparison().isEqualTo(dto);
    }

    @Test
    void toEntity() {
        final var entity = Season.builder()
                                 .id(10L)
                                 .title("winter 24/25")
                                 .startDate(LocalDate.of(2024, 1, 1))
                                 .endDate(LocalDate.of(2024, 6, 1))
                                 .build();

        final var dto = SeasonDto.builder()
                                 .id(10L)
                                 .title("winter 24/25")
                                 .startDate(LocalDate.of(2024, 1, 1))
                                 .endDate(LocalDate.of(2024, 6, 1))
                                 .build();

        //
        final var result = converter.toEntity(dto);
        //

        assertThat(result).usingRecursiveComparison().isEqualTo(entity);
    }
}