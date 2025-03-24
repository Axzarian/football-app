package org.axzarian.footballtestapp.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.axzarian.footballtestapp.dto.CreateArbiterDto;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ArbiterController.class)
class ArbiterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    ArbiterService arbiterService;

    @Test
    void testCreate() throws Exception {
        final var requestDto = CreateArbiterDto.builder()
                                               .firstName("Wolfgang")
                                               .lastName("Berg")
                                               .birthDate(LocalDate.of(1990, 1, 1))
                                               .build();

        final var savedDto = CreateArbiterDto.builder()
                                             .id(10L)
                                             .firstName("Wolfgang")
                                             .lastName("Berg")
                                             .birthDate(LocalDate.of(1990, 1, 1))
                                             .build();

        when(arbiterService.create(requestDto)).thenReturn(savedDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/arbiters")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(objectMapper.writeValueAsString(requestDto)))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(savedDto.id()))
               .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(savedDto.firstName()))
               .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(savedDto.lastName()));


    }
}