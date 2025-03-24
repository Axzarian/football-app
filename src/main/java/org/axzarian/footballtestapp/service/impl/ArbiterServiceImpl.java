package org.axzarian.footballtestapp.service.impl;

import lombok.AllArgsConstructor;
import org.axzarian.footballtestapp.converter.ArbiterConverter;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArbiterServiceImpl implements ArbiterService {

    private final ArbiterRepository arbiterRepository;
    private final ArbiterConverter  arbiterConverter;

    @Override
    public CreateArbiterDto create(CreateArbiterDto arbiterDto) {

        final var entity = arbiterConverter.toEntity(arbiterDto);
        final var saved  = arbiterRepository.save(entity);

        return arbiterConverter.toDto(saved);
    }
}
