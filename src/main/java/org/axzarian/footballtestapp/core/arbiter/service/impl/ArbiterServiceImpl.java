package org.axzarian.footballtestapp.core.arbiter.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.arbiter.converter.ArbiterConverter;
import org.axzarian.footballtestapp.core.arbiter.dto.ArbiterDto;
import org.axzarian.footballtestapp.core.arbiter.Arbiter;
import org.axzarian.footballtestapp.core.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.core.arbiter.repository.ArbiterRepository;
import org.axzarian.footballtestapp.core.arbiter.service.ArbiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArbiterServiceImpl implements ArbiterService {

    private final ArbiterRepository arbiterRepository;
    private final ArbiterConverter  arbiterConverter;

    @Override
    public ArbiterDto create(ArbiterDto arbiterDto) {
        final var entity = arbiterConverter.toEntity(arbiterDto);
        final var saved  = arbiterRepository.save(entity);

        return arbiterConverter.toDto(saved);
    }

    @Override
    public Page<ArbiterDto> findAll(Pageable pageable) {
        final var sortType    = Sort.sort(Arbiter.class);
        final var defaultSort = sortType.by(Arbiter::getId);

        final var sort           = pageable.getSort().isSorted() ? pageable.getSort() : defaultSort;
        final var sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        final var arbitersPage   = arbiterRepository.findAll(sortedPageable);

        return arbitersPage.map(arbiterConverter::toDto);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return arbiterRepository.deleteArbiterById(id) > 0;
    }

    @Override
    @Transactional
    public ArbiterDto update(Long id, ArbiterDto arbiterDto) {

        return arbiterRepository
            .findById(id)
            .map(arbiter -> {
                arbiter.setFirstName(arbiterDto.firstName());
                arbiter.setLastName(arbiterDto.lastName());
                arbiter.setBirthDate(arbiterDto.birthDate());
                final var saved = arbiterRepository.save(arbiter);
                return arbiterConverter.toDto(saved);
            })
            .orElseThrow(() -> new EntityDoesNotExist("There is no arbiter with id: %s ".formatted(id)));
    }

    @Override
    public ArbiterDto find(Long id) {

        return arbiterRepository
            .findById(id)
            .map(arbiterConverter::toDto)
            .orElseThrow(() -> new EntityDoesNotExist("There is no arbiter with id: %s ".formatted(id)));

    }
}
