 package com.example.helloworld.controller;
 import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 @SpringBootTest
 @AutoConfigureMockMvc
 public class HelloWorldControllerTest {

     @Autowired
     private MockMvc mockMvc;
//tests
     @Test
     public void testGetGreeting() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/hello"));
        String responseBody = result.andReturn().getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody);  // Print only the response body
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, World!"));}
    @Test
    public void testPostGreetingResponse() throws Exception {
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/greeting")
                .content("Good Morning")
                .contentType("text/plain"));
        String responseBody = result.andReturn().getResponse().getContentAsString();
        System.out.println("Response Body: " + responseBody);  // Print only the response body
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Message received: Good Morning"));}}
