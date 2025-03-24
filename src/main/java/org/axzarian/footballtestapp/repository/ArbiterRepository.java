package org.axzarian.footballtestapp.repository;

import org.axzarian.footballtestapp.entity.Arbiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbiterRepository extends JpaRepository<Arbiter, Long> {

}
