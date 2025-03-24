package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.springframework.stereotype.Component;

@Component
public class ArbiterConverter {

    public ArbiterDto toDto(Arbiter arbiter) {
        return ArbiterDto.builder()
                         .id(arbiter.getId())
                         .firstName(arbiter.getFirstName())
                         .lastName(arbiter.getLastName())
                         .birthDate(arbiter.getBirthDate())
                         .build();
    }

    public Arbiter toEntity(ArbiterDto dto) {
        return Arbiter.builder()
                      .id(dto.id())
                      .firstName(dto.firstName())
                      .lastName(dto.lastName())
                      .birthDate(dto.birthDate())
                      .build();
    }
}
