package com.jihwi.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class AsychronousRunner implements ApplicationRunner {
    @Autowired
    WebClient.Builder webclientBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient webClient = webclientBuilder.build();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //mono는 stream처럼 subscribe하기 전까지 어떤 일도 일어나지 않는다. (물을 담아두는 개념)
        Mono<String> stringMono = webClient.get().uri("/hello")
                //response 설정
                .retrieve().bodyToMono(String.class);
        stringMono.subscribe(
                s -> {
                    System.out.println(s);

                    if (stopWatch.isRunning()) {
                        stopWatch.stop();
                    }

                    System.out.println(stopWatch.prettyPrint());
                    stopWatch.start();
                }
        );

        Mono<String> stringMono1 = webClient.get().uri("/hi").retrieve().bodyToMono(String.class);
        stringMono1.subscribe(
                s-> {
                    System.out.println(s);
                    if(stopWatch.isRunning()){
                        stopWatch.stop();
                    }
                    System.out.println(stopWatch.prettyPrint());
                    stopWatch.start();
                }
        );
    }
}
