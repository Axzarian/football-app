package org.axzarian.footballtestapp.service.impl;

import lombok.AllArgsConstructor;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        final var arbitersPage = arbiterRepository.findAll(pageable);

        return arbitersPage.map(arbiterConverter::toDto);
    }

}
