package com.ERP.controller;

import com.ERP.entity.HR;
import com.ERP.service.HRService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HRController.class)
class HRControllerTest {

    @MockBean
    HRService hrService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getHR() throws Exception {
        HR hr1 = HR.builder()
                .hrId(1)
                .name("ravinder")
                .password("hr123")
                .role("HR")
                .build();
        HR hr2 = HR.builder()
                .hrId(2)
                .name("akshit")
                .password("hr123")
                .role("HR")
                .build();

        List<HR> hrList = Arrays.asList(hr1, hr2);

        when(hrService.fetchHRList()).thenReturn(hrList);
        mockMvc.perform(get("/hr")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("ravinder"));

    }

    @Test
    void addHR() throws Exception {
        HR hr = HR.builder()
                .hrId(1)
                .name("senior")
                .password("hr123")
                .role("HR")
                .build();

        when(hrService.addHR(hr)).thenReturn(hr);

        mockMvc.perform(post("/addHR")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(hr)))
                .andExpect(status().isOk());
    }

    @Test
    void getHRById() throws Exception {
        HR hr = HR.builder()
                .hrId(1)
                .name("Raj")
                .password("hr123")
                .role("senior")
                .build();

        when(hrService.fetchHRById(1)).thenReturn(hr);

        mockMvc.perform(get("/hr/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Raj"));
    }

    @Test
    void removeHR() throws Exception {
        HR hr = HR.builder()
                .hrId(1)
                .name("Raj")
                .password("hr123")
                .role("senior")
                .build();

        doNothing().when(hrService).removeHR(1);
        mockMvc.perform(delete("/removeHR/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(hr)))
                    .andExpect(status().isOk());

    }

    @Test
    void updateHR() throws Exception {
        HR existedHR = HR.builder()
                .hrId(1)
                .name("ravinder")
                .password("hr123")
                .role("HR")
                .build();
        HR updatedHR = HR.builder()
                .hrId(1)
                .name("Akshit")
                .password("hr")
                .role("H")
                .build();

        when(hrService.updateHR(eq(1), any(HR.class)))
                .thenReturn(updatedHR);

        mockMvc.perform(put("/updateHR/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedHR)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Akshit"));
    }
}