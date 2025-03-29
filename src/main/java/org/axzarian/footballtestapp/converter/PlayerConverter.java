package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.dto.PlayerDto;
import org.axzarian.footballtestapp.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                        .id(player.getId())
                        .firstName(player.getFirstName())
                        .lastName(player.getLastName())
                        .birthDate(player.getBirthDate())
                        .position(player.getPosition())
                        .leg(player.getLeg())
                        .isCaptain(player.isCaptain())
                        .build();
    }

    public Player toEntity(PlayerDto playerDto) {
        return Player.builder()
                     .id(playerDto.id())
                     .firstName(playerDto.firstName())
                     .lastName(playerDto.lastName())
                     .birthDate(playerDto.birthDate())
                     .position(playerDto.position())
                     .leg(playerDto.leg())
                     .isCaptain(playerDto.isCaptain())
                     .build();
    }
}
