package org.axzarian.footballtestapp.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        final var dto = ArbiterDto.builder()
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

        final var dtoWithId = ArbiterDto.builder()
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

    @Test
    void testFindAll() {
        final var arbiterList = List.of(
            Arbiter.builder()
                   .id(10L)
                   .firstName("Wolfgang")
                   .lastName("Berg")
                   .birthDate(LocalDate.of(1990, 1, 1))
                   .build(),

            Arbiter.builder()
                   .id(20L)
                   .firstName("Klaus")
                   .lastName("Richter")
                   .birthDate(LocalDate.of(1980, 1, 1))
                   .build()
        );

        final var arbiterDtoList = List.of(
            ArbiterDto.builder()
                      .id(10L)
                      .firstName("Wolfgang")
                      .lastName("Berg")
                      .birthDate(LocalDate.of(1990, 1, 1))
                      .build(),

            ArbiterDto.builder()
                      .id(20L)
                      .firstName("Klaus")
                      .lastName("Richter")
                      .birthDate(LocalDate.of(1980, 1, 1))
                      .build()
        );

        final var pageable = PageRequest.of(0, 3);

        when(arbiterRepository.findAll(pageable)).thenReturn(new PageImpl<>(arbiterList, pageable, arbiterList.size()));
        when(arbiterConverter.toDto(arbiterList.getFirst())).thenReturn(arbiterDtoList.getFirst());
        when(arbiterConverter.toDto(arbiterList.getLast())).thenReturn(arbiterDtoList.getLast());

        //
        final var page = arbiterService.findAll(pageable);
        //

        assertThat(page.getContent()).hasSize(2);
        assertThat(page.getContent().getFirst().getClass()).isEqualTo(ArbiterDto.class);

    }
}