package org.axzarian.footballtestapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.converter.SeasonConverter;
import org.axzarian.footballtestapp.dto.SeasonDto;
import org.axzarian.footballtestapp.repository.SeasonRepository;
import org.axzarian.footballtestapp.service.SeasonService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final SeasonConverter  seasonConverter;

    @Override
    public SeasonDto create(SeasonDto seasonDto) {
        final var entity = seasonConverter.toEntity(seasonDto);
        final var saved  = seasonRepository.save(entity);

        return seasonConverter.toDto(saved);
    }
}
