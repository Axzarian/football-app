package org.axzarian.footballtestapp.core.player.converter;

import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.player.Player;
import org.axzarian.footballtestapp.core.player_skills.PlayerSkills;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                        .id(player.getId())
                        .firstName(player.getFirstName())
                        .lastName(player.getLastName())
                        .nickname(player.getNickname())
                        .birthDate(player.getBirthDate())
                        .position(player.getPosition())
                        .leg(player.getLeg())
                        .isCaptain(player.isCaptain())
                        .build();
    }

    public PlayerDto toDtoWithSkills(Player player, PlayerSkills playerSkills) {
        return PlayerDto.builder()
                        .id(player.getId())
                        .firstName(player.getFirstName())
                        .lastName(player.getLastName())
                        .nickname(player.getNickname())
                        .birthDate(player.getBirthDate())
                        .position(player.getPosition())
                        .leg(player.getLeg())
                        .isCaptain(player.isCaptain())
                        .passing(playerSkills.getPassing())
                        .shooting(playerSkills.getShooting())
                        .ballControl(playerSkills.getBallControl())
                        .build();
    }

    public Player toEntity(PlayerDto playerDto) {
        return Player.builder()
                     .id(playerDto.id())
                     .firstName(playerDto.firstName())
                     .lastName(playerDto.lastName())
                     .nickname(playerDto.nickname())
                     .birthDate(playerDto.birthDate())
                     .position(playerDto.position())
                     .leg(playerDto.leg())
                     .isCaptain(playerDto.isCaptain())
                     .build();
    }
}
