package com.jihwi.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
//가짜 유저 인증 정보를 넣어서 테스트함. -> 인증 회피 가능
@WithMockUser
public class SecurityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    //특정 가짜 유저 정보를 줄수도 있음.
    public void home() throws Exception {
        mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andDo(print());
    }

    @Test
    public void my() throws Exception {
        mockMvc.perform(get("/my"))
                .andExpect(status().isOk())
                .andExpect(view().name("my"))
                .andDo(print());
    }
}
