package org.axzarian.footballtestapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.List;
import org.axzarian.footballtestapp.dto.ArbiterDto;
import org.axzarian.footballtestapp.service.ArbiterService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        final var requestDto = ArbiterDto.builder()
                                         .firstName("Wolfgang")
                                         .lastName("Berg")
                                         .birthDate(LocalDate.of(1990, 1, 1))
                                         .build();

        final var savedDto = ArbiterDto.builder()
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

    @Test
    void testFindAll() throws Exception {
        final var arbiterList = List.of(
            ArbiterDto.builder()
                      .id(10L)
                      .firstName("Wolfgang")
                      .lastName("Berg")
                      .birthDate(LocalDate.of(1990, 1, 1))
                      .build(),

            ArbiterDto.builder()
                      .id(20L)
                      .firstName("Klaus")
                      .lastName("Richter")
                      .birthDate(LocalDate.of(1980, 1, 1))
                      .build()

        );

        final var page = new PageImpl<>(arbiterList, PageRequest.of(0, 3), arbiterList.size());

        when(arbiterService.findAll(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(MockMvcRequestBuilders.get("/arbiters?page=0&size=3"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray())
               .andExpect(MockMvcResultMatchers.jsonPath("$.content.length()").value(2))
               .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].firstName").value("Wolfgang"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].firstName").value("Klaus"));

        ArgumentCaptor<Pageable> captor = ArgumentCaptor.forClass(Pageable.class);
        verify(arbiterService).findAll(captor.capture());
        Pageable pageable = captor.getValue();
        assertThat(pageable.getPageNumber()).isEqualTo(0);
        assertThat(pageable.getPageSize()).isEqualTo(3);
    }
}