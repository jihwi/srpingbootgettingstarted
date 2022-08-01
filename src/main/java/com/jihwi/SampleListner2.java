package com.jihwi;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class SampleListner2 implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        //톰캣까지 모두 다 뜨고 난 다음에 찍힘.
        System.out.println("===========================");
        System.out.println("application started");
        System.out.println("===========================");
    }
}
