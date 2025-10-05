package org.axzarian.footballtestapp.core.game.service;

import org.axzarian.footballtestapp.core.game.dto.CreateGameDto;
import org.axzarian.footballtestapp.core.game.dto.GameDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {
    GameDto create(CreateGameDto gameDto);

    void finishGame(Long id);

    Page<GameDto> findAll(Pageable pageable);
}
