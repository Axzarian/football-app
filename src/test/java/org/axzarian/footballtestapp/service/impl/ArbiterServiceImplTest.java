package org.axzarian.footballtestapp.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

        final var pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "id"));

        when(arbiterRepository.findAll(pageable)).thenReturn(new PageImpl<>(arbiterList, pageable, arbiterList.size()));
        when(arbiterConverter.toDto(arbiterList.getFirst())).thenReturn(arbiterDtoList.getFirst());
        when(arbiterConverter.toDto(arbiterList.getLast())).thenReturn(arbiterDtoList.getLast());

        //
        final var page = arbiterService.findAll(pageable);
        //

        assertThat(page.getContent()).hasSize(2);
        assertThat(page.getContent().getFirst().getClass()).isEqualTo(ArbiterDto.class);

    }

    @ParameterizedTest
    @CsvSource({"1, true", "0, false"})
    void testDelete(int rows, boolean expected) {
        final var id = 10L;

        when(arbiterRepository.deleteArbiterById(10L)).thenReturn(rows);

        //
        final var result = arbiterService.delete(id);
        //

        verify(arbiterRepository).deleteArbiterById(id);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testUpdate() {
        final var id = 10L;
        final var dto = ArbiterDto.builder()
                                  .firstName("Wolfgang")
                                  .lastName("Berg")
                                  .birthDate(LocalDate.of(1990, 1, 1))
                                  .build();

        final var beforeUpdateEntity = Arbiter.builder()
                                              .id(id)
                                              .firstName("Klaus")
                                              .lastName("Richter")
                                              .birthDate(LocalDate.of(1980, 1, 1))
                                              .build();

        final var afterUpdateEntity = Arbiter.builder()
                                             .id(id)
                                             .firstName("Wolfgang")
                                             .lastName("Berg")
                                             .birthDate(LocalDate.of(1990, 1, 1))
                                             .build();

        final var afterUpdateDto = ArbiterDto.builder()
                                             .id(id)
                                             .firstName("Wolfgang")
                                             .lastName("Berg")
                                             .birthDate(LocalDate.of(1990, 1, 1))
                                             .build();

        when(arbiterRepository.findById(id)).thenReturn(Optional.of(beforeUpdateEntity));
        when(arbiterRepository.save(afterUpdateEntity)).thenReturn(afterUpdateEntity);
        when(arbiterConverter.toDto(afterUpdateEntity)).thenReturn(afterUpdateDto);

        //
        final var updated = arbiterService.update(id, dto);
        //

        assertThat(updated).isEqualTo(afterUpdateDto);
    }
}