package org.axzarian.footballtestapp.core.team.repository;

import org.axzarian.footballtestapp.core.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Modifying
    @Query("delete from Team t where t.id = :id")
    int deleteTeamById(@Param("id") Long id);
}
