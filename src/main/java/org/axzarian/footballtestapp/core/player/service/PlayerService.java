package org.axzarian.footballtestapp.core.player.service;

import jakarta.validation.Valid;
import java.util.List;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;

public interface PlayerService {

    void create(PlayerDto playerDto);

    List<PlayerDto> findAll();

    void delete(Long id);

    PlayerDto update(Long id, @Valid PlayerDto playerDto);

    PlayerDto find(Long id);
}
