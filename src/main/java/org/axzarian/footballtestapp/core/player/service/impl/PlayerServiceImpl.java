package org.axzarian.footballtestapp.core.player.service.impl;


import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axzarian.footballtestapp.core.player.converter.PlayerConverter;
import org.axzarian.footballtestapp.core.player_skills.converter.PlayerSkillsConverter;
import org.axzarian.footballtestapp.core.player.dto.PlayerDto;
import org.axzarian.footballtestapp.core.exception.EntityDoesNotExist;
import org.axzarian.footballtestapp.core.player.repository.PlayerRepository;
import org.axzarian.footballtestapp.core.player.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerConverter  playerConverter;
    private final PlayerSkillsConverter playerSkillsConverter;

    @Override
    @Transactional
    public void create(PlayerDto playerDto) {

        final var player = playerConverter.toEntity(playerDto);

        final var playerSkills = playerSkillsConverter.toEntityBuilder(playerDto)
                                                      .player(player)
                                                      .build();
        player.setPlayerSkills(playerSkills);

        playerRepository.save(player);
    }

    @Override
    public List<PlayerDto> findAll() {

        final var playerList = playerRepository.findAll();
        return playerList.stream().map(playerConverter::toDto).toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerDto update(Long id, PlayerDto playerDto) {
        return playerRepository
            .findById(id)
            .map(player -> {
                player.setFirstName(playerDto.firstName());
                player.setLastName(playerDto.lastName());
                player.setBirthDate(playerDto.birthDate());
                player.setPosition(playerDto.position());
                player.setLeg(playerDto.leg());
                player.setCaptain(playerDto.isCaptain());

                final var playerSkills = player.getPlayerSkills();
                playerSkills.setPassing(playerDto.passing());
                playerSkills.setShooting(playerDto.shooting());
                playerSkills.setBallControl(playerDto.ballControl());

                final var saved = playerRepository.save(player);

                return playerConverter.toDto(saved, playerSkills);
            })
            .orElseThrow(() -> new EntityDoesNotExist("There is no player with id: %s ".formatted(id)));
    }

    @Override
    public PlayerDto find(Long id) {

        return playerRepository
            .findById(id)
            .map(playerConverter::toDto)
            .orElseThrow(() -> new EntityDoesNotExist("There is no player with id: %s "));
    }


}
