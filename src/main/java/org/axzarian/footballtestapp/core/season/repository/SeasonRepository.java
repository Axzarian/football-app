package org.axzarian.footballtestapp.core.season.repository;

import org.axzarian.footballtestapp.core.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
