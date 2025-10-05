package org.axzarian.footballtestapp.core.season.service;

import org.axzarian.footballtestapp.core.season.dto.SeasonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeasonService {

    SeasonDto create(SeasonDto seasonDto);

    Page<SeasonDto> findAll(Pageable pageable);
}
