package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.dto.GameDto;
import org.axzarian.footballtestapp.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameConverter {
    public GameDto toDto(Game game) {
        return GameDto.builder()
                      .id(game.getId())
                      .season(game.getSeason())
                      .gameDate(game.getGameDate())
                      .arbiter(game.getArbiter())
                      .homeTeam(game.getHomeTeam())
                      .awayTeam(game.getAwayTeam())
                      .homeTeamGoals(game.getHomeTeamGoals())
                      .awayTeamGoals(game.getAwayTeamGoals())
                      .yellowCards(game.getYellowCards())
                      .redCards(game.getRedCards())
                      .isFinished(game.isFinished())
                      .result(game.getResult())
                      .build();
    }
}
