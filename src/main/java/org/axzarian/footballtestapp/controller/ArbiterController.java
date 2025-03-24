package org.axzarian.footballtestapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateArbiterDto> create(@Valid @RequestBody CreateArbiterDto arbiterDto) {

        final var saved = arbiterService.create(arbiterDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
