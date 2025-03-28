package org.axzarian.footballtestapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.SeasonDto;
import org.axzarian.footballtestapp.service.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
