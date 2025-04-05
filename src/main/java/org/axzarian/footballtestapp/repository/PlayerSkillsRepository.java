package org.axzarian.footballtestapp.repository;

import org.axzarian.footballtestapp.entity.PlayerSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSkillsRepository extends JpaRepository<PlayerSkills, Long> {
}
