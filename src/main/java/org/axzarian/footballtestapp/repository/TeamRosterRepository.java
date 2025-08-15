package org.axzarian.footballtestapp.repository;

import java.util.List;
import org.axzarian.footballtestapp.dto.PlayerDto;
import org.axzarian.footballtestapp.entity.TeamRoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRosterRepository extends JpaRepository<TeamRoster, Long> {

    @Query(
        "SELECT new org.axzarian.footballtestapp.dto.PlayerDto(" +
        "p.id, p.firstName, p.lastName, p.birthDate, p.position, p.leg, p.isCaptain, " +
        "ps.passing, ps.shooting, ps.ballControl) " +
        "FROM TeamRoster tr " +
        "JOIN tr.player p " +
        "JOIN p.playerSkills ps " +
        "WHERE tr.season.id = :seasonId " +
        "AND tr.team.id = :teamId"
    )
    List<PlayerDto> findPlayersBySeasonAndTeamIds(Long seasonId, Long teamId);

}
