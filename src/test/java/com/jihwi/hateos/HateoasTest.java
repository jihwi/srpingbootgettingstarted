package com.jihwi.hateos;

import com.jihwi.hateoas.HateoasController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HateoasController.class)
public class HateoasTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/hateoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists())
                .andDo(print());
    }
}
