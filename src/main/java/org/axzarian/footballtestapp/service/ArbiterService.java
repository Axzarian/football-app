package org.axzarian.footballtestapp.service;

import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArbiterService {
    ArbiterDto create(ArbiterDto arbiter);

    Page<ArbiterDto> findAll(Pageable pageable);

}
