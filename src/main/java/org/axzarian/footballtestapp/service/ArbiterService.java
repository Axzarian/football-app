package org.axzarian.footballtestapp.service;

import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArbiterService {

    ArbiterDto create(ArbiterDto arbiterDto);

    Page<ArbiterDto> findAll(Pageable pageable);

    boolean delete(Long id);

    ArbiterDto update(Long id, ArbiterDto arbiterDto);

    ArbiterDto find(Long id);
}
