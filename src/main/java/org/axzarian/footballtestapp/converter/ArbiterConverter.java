package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.entity.Arbiter;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.springframework.stereotype.Component;

@Component
public class ArbiterConverter {

    public CreateArbiterDto toDto(Arbiter arbiter) {
        return CreateArbiterDto.builder()
                               .id(arbiter.getId())
                               .firstName(arbiter.getFirstName())
                               .lastName(arbiter.getLastName())
                               .birthDate(arbiter.getBirthDate())
                               .build();
    }

    public Arbiter toEntity(CreateArbiterDto dto) {
        return Arbiter.builder()
                      .id(dto.id())
                      .firstName(dto.firstName())
                      .lastName(dto.lastName())
                      .birthDate(dto.birthDate())
                      .build();
    }
}
