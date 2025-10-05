package org.axzarian.footballtestapp.service.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.axzarian.footballtestapp.core.season.converter.SeasonConverter;
import org.axzarian.footballtestapp.core.season.dto.SeasonDto;
import org.axzarian.footballtestapp.core.season.Season;
import org.axzarian.footballtestapp.core.season.repository.SeasonRepository;
import org.axzarian.footballtestapp.core.season.service.impl.SeasonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SeasonServiceImplTest {

    @Mock
    private SeasonRepository seasonRepository;

    @Mock
    private SeasonConverter seasonConverter;

    @InjectMocks
    private SeasonServiceImpl seasonService;

    @Test
    void testCreate() {
        final var requestDto = SeasonDto.builder()
                                        .title("winter 24/25")
                                        .startDate(LocalDate.of(2024, 1, 1))
                                        .endDate(LocalDate.of(2024, 6, 1))
                                        .build();

        final var beforeSaveEntity = Season.builder()
                                           .title("winter 24/25")
                                           .startDate(LocalDate.of(2024, 1, 1))
                                           .endDate(LocalDate.of(2024, 6, 1))
                                           .build();

        final var afterSaveEntity = Season.builder()
                                          .id(10L)
                                          .title("winter 24/25")
                                          .startDate(LocalDate.of(2024, 1, 1))
                                          .endDate(LocalDate.of(2024, 6, 1))
                                          .build();

        final var responseDto = SeasonDto.builder()
                                         .id(10L)
                                         .title("winter 24/25")
                                         .startDate(LocalDate.of(2024, 1, 1))
                                         .endDate(LocalDate.of(2024, 6, 1))
                                         .build();

        when(seasonConverter.toEntity(requestDto)).thenReturn(beforeSaveEntity);
        when(seasonRepository.save(beforeSaveEntity)).thenReturn(afterSaveEntity);
        when(seasonConverter.toDto(afterSaveEntity)).thenReturn(responseDto);

        //
        final var saved = seasonService.create(requestDto);
        //

        assertThat(saved).usingRecursiveComparison().isEqualTo(responseDto);
    }
}