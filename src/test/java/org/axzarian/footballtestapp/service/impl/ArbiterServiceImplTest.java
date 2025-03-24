package org.axzarian.footballtestapp.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArbiterServiceImplTest {

    @Mock
    private ArbiterRepository arbiterRepository;

    @Mock
    private ArbiterConverter arbiterConverter;

    @InjectMocks
    ArbiterServiceImpl arbiterService;

    @Test
    void testCreate() {
        final var dto = CreateArbiterDto.builder()
                                        .firstName("Wolfgang")
                                        .lastName("Berg")
                                        .birthDate(LocalDate.of(1990, 1, 1))
                                        .build();

        final var entityWithoudId = Arbiter.builder()
                                           .firstName("Wolfgang")
                                           .lastName("Berg")
                                           .birthDate(LocalDate.of(1990, 1, 1))
                                           .build();

        final var entityWithdId = Arbiter.builder()
                                         .id(10L)
                                         .firstName("Wolfgang")
                                         .lastName("Berg")
                                         .birthDate(LocalDate.of(1990, 1, 1))
                                         .build();

        final var dtoWithId = CreateArbiterDto.builder()
                                              .id(10L)
                                              .firstName("Wolfgang")
                                              .lastName("Berg")
                                              .birthDate(LocalDate.of(1990, 1, 1))
                                              .build();

        when(arbiterConverter.toEntity(dto)).thenReturn(entityWithoudId);
        when(arbiterRepository.save(entityWithoudId)).thenReturn(entityWithdId);
        when(arbiterConverter.toDto(entityWithdId)).thenReturn(dtoWithId);

        //
        final var save = arbiterService.create(dto);
        //

        assertThat(save).usingRecursiveComparison().isEqualTo(dtoWithId);
    }
}