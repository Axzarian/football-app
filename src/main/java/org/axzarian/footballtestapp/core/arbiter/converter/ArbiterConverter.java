package org.axzarian.footballtestapp.core.arbiter.converter;

import org.axzarian.footballtestapp.core.arbiter.Arbiter;
import org.axzarian.footballtestapp.core.arbiter.dto.ArbiterDto;
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
