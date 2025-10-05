package org.axzarian.footballtestapp.service;

import java.util.List;
import org.axzarian.footballtestapp.dto.CreateGameDto;
import org.axzarian.footballtestapp.dto.GameDto;
import org.axzarian.footballtestapp.entity.Game;
import org.springframework.data.domain.Pageable;

public interface GameService {
    Game create(CreateGameDto gameDto);

    void finishGame(Long id);

    List<GameDto> findAll(Pageable pageable);
}
