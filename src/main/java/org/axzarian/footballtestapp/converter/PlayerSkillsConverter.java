package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.dto.PlayerDto;
import org.axzarian.footballtestapp.entity.PlayerSkills;
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
