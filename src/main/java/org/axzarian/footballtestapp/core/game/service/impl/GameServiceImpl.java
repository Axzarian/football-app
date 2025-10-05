package org.axzarian.footballtestapp.core.game.service.impl;

import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.game.converter.GameConverter;
import org.axzarian.footballtestapp.core.game.dto.CreateGameDto;
import org.axzarian.footballtestapp.core.game.dto.GameDto;
import org.axzarian.footballtestapp.core.game.Game;
import org.axzarian.footballtestapp.core.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.core.arbiter.repository.ArbiterRepository;
import org.axzarian.footballtestapp.core.game.repository.GameRepository;
import org.axzarian.footballtestapp.core.season.repository.SeasonRepository;
import org.axzarian.footballtestapp.core.team.repository.TeamRepository;
import org.axzarian.footballtestapp.core.game.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository    gameRepository;
    private final TeamRepository    teamRepository;
    private final SeasonRepository  seasonRepository;
    private final ArbiterRepository arbiterRepository;
    private final GameConverter     gameConverter;

    @Override
    public GameDto create(CreateGameDto gameDto) {

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
                             .homeTeamGoals(0)
                             .awayTeamGoals(0)
                             .yellowCards(0)
                             .redCards(0)
                             .isFinished(false)
                             .build();

        final var saved = gameRepository.save(game);
        return gameConverter.toDto(saved);
    }

    @Override
    public void finishGame(Long id) {
        final var game = gameRepository.findById(id).orElseThrow(() -> new EntityDoesNotExist("Game id not found"));
        game.setFinished(true);
        gameRepository.save(game);
    }

    @Override
    public Page<GameDto> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable)
                             .map(gameConverter::toDto);
    }
}
