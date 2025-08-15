package org.axzarian.footballtestapp.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeasonTeamRosterDto {
    private String seasonTitle;
    private String teamTitle;
    private List<PlayerDto> players;
}
