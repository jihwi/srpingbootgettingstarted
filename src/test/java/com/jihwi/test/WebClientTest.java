package com.jihwi.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClientTest {

    @Autowired
    WebTestClient webTestClient;

    //로그 검사할때 log capture해서 assertThat
    //근데 로그를 검사할일 거의 없어서 사용안할듯.
    @Rule //junit의 애너테이션
    public OutputCapture outputCapture = new OutputCapture(); //필수적으로 public 이여야함.

    @Test
    public void test(){
        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("hello jihwi");

        assertThat(outputCapture.toString()).contains("log")
                .contains("테스트");
    }
}
