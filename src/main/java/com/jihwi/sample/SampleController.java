package com.jihwi.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);
    @Autowired
    private SampleSerivce sampleSerivce;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        logger.debug("log 남기기");
        System.out.println("이것도 남는지 테스트");
        Thread.sleep(3000);
        return "hello " + sampleSerivce.getName();
    }

    @GetMapping("/hi")
    public String hi() throws InterruptedException {
        Thread.sleep(1000);
        return "hi" + sampleSerivce.getName();
    }
}
