package com.jihwi;

import com.example.Holoman;
import com.example.HolomanProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

//@Component
public class HolomanRunner implements ApplicationRunner {

    @Autowired
    Holoman holoman;

    @Autowired
    HolomanProperties properties;

    @Autowired
    UrlProperties urlProperties;

    @Autowired
    String hello;

    @Value("${url.prddb}")
    String dburl;

    @Value("${url.custom.image}")
    String imageUrl;

    //외부 의존 프로젝트의 properties를 못읽어들임.(그럼 전시에 core.yml은 어디에어떻게 등록해놧길래 우선순위로 읽을 수 있게 된거지?)
//    @Value("${url.custom.vod}")
//    String vodUrl;


    private Logger logger = LoggerFactory.getLogger(HolomanRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("!!!!!!!!!!!!!!!!!!!!!!!");
        logger.debug(hello);
        logger.debug(urlProperties.getImage());
        logger.debug(properties.getName());
        logger.debug(holoman.toString());
        logger.debug(dburl);
        logger.debug(imageUrl);
//        logger.debug(vodUrl);
//
//        System.out.println("===========");
//        System.out.println(hello);
//        System.out.println("===========");
//
//        System.out.println(urlProperties.getWeb());
//        System.out.println(urlProperties.getImage());
//        System.out.println(datasourceUrl);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(holoman);
//        System.out.println(urlProperties.getImage());
//        System.out.println(urlProperties.getWeb());
//        System.out.println(urlProperties.getConnectionTimeout());
//    }
}
