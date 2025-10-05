package org.axzarian.footballtestapp.interfaces.rest.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.player.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;


    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody PlayerDto playerDto) {
        playerService.create(playerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PlayerDto>> findAll(Pageable pageable) {
        final var dtoList = playerService.findAll(pageable);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return playerService.delete(id)
               ? new ResponseEntity<>(HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> update(@Valid @RequestBody PlayerDto playerDto, @PathVariable Long id) {
        return ResponseEntity.ok(playerService.update(id, playerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.find(id));
    }

}
