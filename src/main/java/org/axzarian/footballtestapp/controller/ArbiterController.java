package org.axzarian.footballtestapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.service.ArbiterService;
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
@RestController()
@RequiredArgsConstructor
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        final var isDeleted = arbiterService.delete(id);

        return isDeleted
               ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArbiterDto> update(@Valid @RequestBody ArbiterDto arbiterDto, @PathVariable Long id) {
        return ResponseEntity.ok(arbiterService.update(id, arbiterDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbiterDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(arbiterService.find(id));
    }
}


















