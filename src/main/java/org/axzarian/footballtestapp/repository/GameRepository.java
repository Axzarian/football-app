package org.axzarian.footballtestapp.repository;

import org.axzarian.footballtestapp.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
