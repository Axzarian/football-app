package org.axzarian.footballtestapp.core.player.repository;

import org.axzarian.footballtestapp.core.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Modifying
    @Query("delete from Player p where p.id = :id")
    int deletePlayerById(@Param("id") Long id);

}
