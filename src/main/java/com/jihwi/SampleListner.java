package com.jihwi;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class SampleListner implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("application is starting");
        //배너 위 가장 처음에 나오는 로그
        System.out.println(applicationStartingEvent.getSource());
    }
}
