package org.axzarian.footballtestapp.service;

import jakarta.validation.Valid;
import java.util.List;
import org.axzarian.footballtestapp.dto.PlayerDto;
import org.springframework.http.ResponseEntity;

public interface PlayerService {

    PlayerDto create(PlayerDto playerDto);

    List<PlayerDto> findAll();

    boolean delete(Long id);

    PlayerDto update(Long id, @Valid PlayerDto playerDto);

    PlayerDto find(Long id);
}
