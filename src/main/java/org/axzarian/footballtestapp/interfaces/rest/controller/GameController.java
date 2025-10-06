package org.axzarian.footballtestapp.interfaces.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.game.dto.CreateGameDto;
import org.axzarian.footballtestapp.core.game.dto.GameDto;
import org.axzarian.footballtestapp.core.game.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameDto> create(@RequestBody @Valid CreateGameDto gameDto) {
        return ResponseEntity.ok(gameService.create(gameDto));
    }

    @PatchMapping("/{id}/finish")
    public ResponseEntity<?> finishGame(@PathVariable Long id) {
        gameService.finishGame(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Page<GameDto> findAll(Pageable pageable) {
        return gameService.findAll(pageable);
    }
}
