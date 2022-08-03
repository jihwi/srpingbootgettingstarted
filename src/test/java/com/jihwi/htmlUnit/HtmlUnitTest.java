package com.jihwi.htmlUnit;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.jihwi.thymeleaf.ThymeleafController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(ThymeleafController.class)
/**
 * html 특화 테스트 작성 가능
 */
public class HtmlUnitTest {

    @Autowired
    //htmlunit의 webclient
    WebClient webClient;

    @Test
    public void test() throws IOException {
        HtmlPage page = webClient.getPage("/thymeleaf");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualTo("keesun");
    }
}
