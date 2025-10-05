package org.axzarian.footballtestapp.core.game.service;

import java.util.List;
import org.axzarian.footballtestapp.core.game.dto.CreateGameDto;
import org.axzarian.footballtestapp.core.game.dto.GameDto;
import org.axzarian.footballtestapp.core.game.Game;
import org.springframework.data.domain.Pageable;

public interface GameService {
    Game create(CreateGameDto gameDto);

    void finishGame(Long id);

    List<GameDto> findAll(Pageable pageable);
}
