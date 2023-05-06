package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalulatorControllerMock {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorController calculatorControllerMock;

    @Test
    public void HelloTest() throws Exception {
        Mockito.when(calculatorControllerMock.hello()).thenReturn("Bonjour");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bonjour"));
    }
}
