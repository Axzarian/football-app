package org.axzarian.footballtestapp.controller;

import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.GameDto;
import org.axzarian.footballtestapp.entity.Game;
import org.axzarian.footballtestapp.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public Game create(@RequestBody GameDto gameDto) {
        return gameService.create(gameDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> finishGame(@PathVariable Long id) {
        gameService.finishGame(id);
        return ResponseEntity.ok().build();
    }
}
