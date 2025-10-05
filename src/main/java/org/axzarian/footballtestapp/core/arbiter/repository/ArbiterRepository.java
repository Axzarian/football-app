package org.axzarian.footballtestapp.core.arbiter.repository;

import org.axzarian.footballtestapp.core.arbiter.Arbiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbiterRepository extends JpaRepository<Arbiter, Long> {

    @Modifying
    @Query("delete from Arbiter a where a.id = :id")
    int deleteArbiterById(@Param("id") Long id);

}
