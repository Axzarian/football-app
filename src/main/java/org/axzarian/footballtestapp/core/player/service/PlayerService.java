package org.axzarian.footballtestapp.core.player.service;

import jakarta.validation.Valid;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlayerService {

    void create(PlayerDto playerDto);

    Page<PlayerDto> findAll(Pageable pageable);

    boolean delete(Long id);

    PlayerDto update(Long id, @Valid PlayerDto playerDto);

    PlayerDto find(Long id);
}
