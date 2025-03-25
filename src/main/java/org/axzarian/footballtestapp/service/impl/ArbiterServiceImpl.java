package org.axzarian.footballtestapp.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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

        final var sort           = pageable.getSort().isSorted() ? pageable.getSort() : Sort.by("id").ascending();
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
        if (arbiterRepository.existsById(id)) {
            final var entity = arbiterConverter.toEntity(arbiterDto);
            final var saved  = arbiterRepository.save(entity);
            return arbiterConverter.toDto(saved);
        }
        throw new EntityDoesNotExist("There is no arbiter with id: %s ".formatted(id));
    }


}
