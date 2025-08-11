package org.axzarian.footballtestapp.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.PlayerDto;
import org.axzarian.footballtestapp.dto.SeasonTeamRosterDto;
import org.axzarian.footballtestapp.dto.TeamRosterDto;
import org.axzarian.footballtestapp.service.TeamRosterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team-rosters")
@RequiredArgsConstructor
public class TeamRosterController {

    private final TeamRosterService teamRosterService;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody TeamRosterDto teamRosterDto) {
        teamRosterService.create(teamRosterDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllBySeasonAndTeam(
        @RequestParam Long seasonId,
        @RequestParam Long teamId
    ) {
        final var rosters = teamRosterService.getBySeasonAndTeam(seasonId, teamId);
        return ResponseEntity.ok(rosters);
    }

    @GetMapping("/test")
    public ResponseEntity<SeasonTeamRosterDto> getAllBySeasonAndTeamTest(
        @RequestParam Long seasonId,
        @RequestParam Long teamId
    ) {
        final var rosters = teamRosterService.getBySeasonAndTeamTest(seasonId, teamId);
        return ResponseEntity.ok(rosters);
    }

}
