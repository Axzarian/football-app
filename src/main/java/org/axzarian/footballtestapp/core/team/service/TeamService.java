package org.axzarian.footballtestapp.core.team.service;

import java.util.List;
import org.axzarian.footballtestapp.core.team.dto.TeamDto;
import org.springframework.data.domain.Pageable;

public interface TeamService {
    void create(TeamDto teamDto);

    TeamDto findById(Long id);

    List<TeamDto> findAll(Pageable pageable);

    boolean delete(Long id);
}
