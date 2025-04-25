package org.axzarian.footballtestapp.repository;

import org.axzarian.footballtestapp.entity.TeamRoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRosterRepository extends JpaRepository<TeamRoster, Long> {
}
