package org.axzarian.footballtestapp.interfaces.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.season.dto.SeasonDto;
import org.axzarian.footballtestapp.core.season.service.SeasonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/seasons")
@RequiredArgsConstructor
public class SeasonController {

    public final SeasonService seasonService;

    @PostMapping
    public ResponseEntity<SeasonDto> create(@Valid @RequestBody SeasonDto seasonDto) {
        final var saved = seasonService.create(seasonDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<SeasonDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(seasonService.findAll(pageable));
    }
}
