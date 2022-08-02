package com.jihwi.mvc;

import com.jihwi.user.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"keesun\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",is(equalTo("keesun"))))
                .andExpect(jsonPath("$.password",is(equalTo("123"))));
    }

    @Test
    //org.springframework.web.HttpMediaTypeNotAcceptableException(406)
    //xml에 맞는 viewResolver가 없다.
    //httpMessageConvertersAutoConfiguration 안 JacksonHttpMessageConvertersConfiguration보면
    //
    //    @Configuration
    //    @ConditionalOnClass({XmlMapper.class})
    //    @ConditionalOnBean({Jackson2ObjectMapperBuilder.class})
    //    protected static class MappingJackson2XmlHttpMessageConverterConfiguration {
    //        protected MappingJackson2XmlHttpMessageConverterConfiguration() {
    //        }
    //
    //  => pom.xml 에 xml메세지 컴버터 추가
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"keesun\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson)
                        .accept(MediaType.APPLICATION_ATOM_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("keesun"))
                .andExpect(xpath("/User/password").string("123"));
    }
}
