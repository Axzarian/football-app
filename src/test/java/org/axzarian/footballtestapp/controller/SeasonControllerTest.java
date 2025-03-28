package org.axzarian.footballtestapp.controller;


import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.axzarian.footballtestapp.dto.SeasonDto;
import org.axzarian.footballtestapp.service.SeasonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = SeasonController.class)
class SeasonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    private SeasonService seasonService;


    @Test
    void testCreate() throws Exception {
        final var requestDto = SeasonDto.builder()
                                        .title("winter 24/25")
                                        .startDate(LocalDate.of(2024, 10, 1))
                                        .endDate(LocalDate.of(2025, 5, 1))
                                        .build();

        final var responseDto = SeasonDto.builder()
                                         .id(11L)
                                         .title("winter 24/25")
                                         .startDate(LocalDate.of(2024, 10, 1))
                                         .endDate(LocalDate.of(2025, 5, 1))
                                         .build();

        when(seasonService.create(requestDto)).thenReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/seasons")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(objectMapper.writeValueAsString(requestDto)))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(11L));
    }
}