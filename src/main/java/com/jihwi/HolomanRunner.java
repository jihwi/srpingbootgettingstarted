package com.jihwi;

import com.example.Holoman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolomanRunner implements ApplicationRunner {

    @Autowired
    Holoman holoman;

    @Autowired
    UrlProperties urlProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holoman);
        System.out.println(urlProperties.getImage());
        System.out.println(urlProperties.getWeb());
        System.out.println(urlProperties.getConnectionTimeout());
    }
}
