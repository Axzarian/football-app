package org.axzarian.footballtestapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
@RequestMapping("/arbiters")
public class ArbiterController {

    private final ArbiterService arbiterService;


    @PostMapping
    public ResponseEntity<ArbiterDto> create(@Valid @RequestBody ArbiterDto arbiterDto) {
        final var saved = arbiterService.create(arbiterDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ArbiterDto>> findAll(Pageable pageable) {
        final var page = arbiterService.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
