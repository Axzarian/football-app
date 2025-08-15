package org.axzarian.footballtestapp.service;

import java.util.List;
import org.axzarian.footballtestapp.dto.TeamDto;

public interface TeamService {
    void create(TeamDto teamDto);

    TeamDto findById(Long id);

    List<TeamDto> findAll();
}
