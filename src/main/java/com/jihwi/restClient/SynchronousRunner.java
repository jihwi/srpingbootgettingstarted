package com.jihwi.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
@Order(2)
public class SynchronousRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestTemplate restTemplate = restTemplateBuilder.build();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String forObject = restTemplate.getForObject("/hello", String.class);
        System.out.println(forObject);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        stopWatch.start();
        String forObject1 = restTemplate.getForObject("/hi", String.class);
        System.out.println(forObject1);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
