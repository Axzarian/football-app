package org.axzarian.footballtestapp.core.player_skills.repository;

import org.axzarian.footballtestapp.core.player_skills.PlayerSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSkillsRepository extends JpaRepository<PlayerSkills, Long> {
}
