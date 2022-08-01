package com.jihwi;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class Argument {
    public Argument(ApplicationArguments args) {
        //JVM옵션은 받지 못하고 applicationArguments
        System.out.println("foo:" + args.containsOption("foo"));
        System.out.println("bar:" + args.containsOption("bar"));
    }
}
