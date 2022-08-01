package com.jihwi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//스프링부트테스트 애너테이션만으로 안됨. runwith가 들어가야하네?
@RunWith(SpringRunner.class)
//이렇게 test용 property를 직접 세팅
//@TestPropertySource(properties = "holoman.name=jihwi")
//만약 변경 프로퍼티가 많으면
@TestPropertySource(locations = "classpath:/test.properties")
public class SpringinitApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void test(){
        assertThat(environment.getProperty("holoman.name"))
                .isEqualTo("jiwon");
    }
}
