package org.axzarian.footballtestapp.core.team_roster.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonTeamRosterDto {
    private String          seasonTitle;
    private String          teamTitle;
    private List<PlayerDto> players;
}
