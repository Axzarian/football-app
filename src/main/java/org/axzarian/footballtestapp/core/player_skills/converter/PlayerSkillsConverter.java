package org.axzarian.footballtestapp.core.player_skills.converter;

import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.player_skills.PlayerSkills;
import org.springframework.stereotype.Component;

@Component
public class PlayerSkillsConverter {

    public PlayerSkills.PlayerSkillsBuilder toEntityBuilder(PlayerDto playerDto) {
        return PlayerSkills.builder()
                           .passing(playerDto.passing())
                           .shooting(playerDto.shooting())
                           .ballControl(playerDto.ballControl());
    }
}
