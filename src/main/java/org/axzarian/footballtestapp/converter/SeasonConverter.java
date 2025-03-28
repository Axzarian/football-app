package org.axzarian.footballtestapp.converter;

import org.axzarian.footballtestapp.dto.SeasonDto;
import org.axzarian.footballtestapp.entity.Season;
import org.springframework.stereotype.Component;

@Component
public class SeasonConverter {

    public SeasonDto toDto(Season season) {
        return SeasonDto.builder()
                        .id(season.getId())
                        .title(season.getTitle())
                        .startDate(season.getStartDate())
                        .endDate(season.getEndDate())
                        .build();
    }

    public Season toEntity(SeasonDto seasonDto) {
        return Season.builder()
                     .id(seasonDto.id())
                     .title(seasonDto.title())
                     .startDate(seasonDto.startDate())
                     .endDate(seasonDto.endDate())
                     .build();
    }
}
