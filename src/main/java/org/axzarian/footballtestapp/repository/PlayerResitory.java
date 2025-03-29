package org.axzarian.footballtestapp.repository;

import org.axzarian.footballtestapp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerResitory extends JpaRepository<Player, Long> {

    @Modifying
    @Query("delete from Player p where p.id = :id")
    int deletePlayerById(@Param("id") Long id);

}
