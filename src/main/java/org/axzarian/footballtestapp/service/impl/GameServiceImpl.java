package org.axzarian.footballtestapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.dto.GameDto;
import org.axzarian.footballtestapp.entity.Game;
import org.axzarian.footballtestapp.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.repository.ArbiterRepository;
import org.axzarian.footballtestapp.repository.GameRepository;
import org.axzarian.footballtestapp.repository.SeasonRepository;
import org.axzarian.footballtestapp.repository.TeamRepository;
import org.axzarian.footballtestapp.service.GameService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository    gameRepository;
    private final TeamRepository    teamRepository;
    private final SeasonRepository  seasonRepository;
    private final ArbiterRepository arbiterRepository;

    @Override
    public Game create(GameDto gameDto) {

        final var arbiter = arbiterRepository.findById(gameDto.arbiterId())
                                             .orElseThrow(() -> new EntityDoesNotExist("ArbiterId not found"));

        final var homeTeam = teamRepository.findById(gameDto.homeTeamId())
                                           .orElseThrow(() -> new EntityDoesNotExist("Home team not found"));

        final var awayTeam = teamRepository.findById(gameDto.awayTeamId())
                                           .orElseThrow(() -> new EntityDoesNotExist("Away team not found"));

        final var season = seasonRepository.findById(gameDto.seasonId())
                                           .orElseThrow(() -> new EntityDoesNotExist("Season not found"));

        final var game = Game.builder()
                             .season(season)
                             .gameDate(gameDto.gameDate())
                             .arbiter(arbiter)
                             .homeTeam(homeTeam)
                             .awayTeam(awayTeam)
                             .build();

        return gameRepository.save(game);
    }

    @Override
    public void finishGame(Long id) {
        final var game = gameRepository.findById(id).orElseThrow(() -> new EntityDoesNotExist("Game id not found"));
        game.setFinished(true);
        gameRepository.save(game);
    }
}
