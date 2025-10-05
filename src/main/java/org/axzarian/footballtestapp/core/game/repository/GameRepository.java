package org.axzarian.footballtestapp.core.game.repository;

import org.axzarian.footballtestapp.core.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
