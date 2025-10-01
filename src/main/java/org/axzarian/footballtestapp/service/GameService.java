package org.axzarian.footballtestapp.service;

import org.axzarian.footballtestapp.dto.GameDto;
import org.axzarian.footballtestapp.entity.Game;

public interface GameService {
    Game create(GameDto gameDto);
    void finishGame(Long id);
}
