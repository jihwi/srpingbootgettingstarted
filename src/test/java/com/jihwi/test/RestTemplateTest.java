package com.jihwi.test;

import com.jihwi.sample.SampleController;
import com.jihwi.sample.SampleSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SampleSerivce mockSampleSerivce;

    @Test
    public void test(){
        when(mockSampleSerivce.getName()).thenReturn("whiteship");
        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hello whiteship");
    }
}
