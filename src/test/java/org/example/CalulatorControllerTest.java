package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalulatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void HelloTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to online simple calculator!"));
    }

    @Test
    public void TestAdd() throws Exception {
        mockMvc.perform(get("/calculate?operation=add&a=1&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

    @Test
    public void TestAdd_missing_parameter() throws Exception {
        mockMvc.perform(get("/calculate?operation=add&a=1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(""));
    }

    @Test
    public void TestAdd_bad_operation() throws Exception {
        mockMvc.perform(get("/calculate?operation=addition&a=1&b=2"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof BadArgumentException))
                .andExpect(result -> Assertions.assertEquals("Invalid operation: addition", result.getResolvedException().getMessage()));
    }

    @Test
    public void TestDiv_by_zero() throws Exception {
        mockMvc.perform(get("/calculate?operation=div&a=1&b=0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cannot divide by zero"));
    }

}
