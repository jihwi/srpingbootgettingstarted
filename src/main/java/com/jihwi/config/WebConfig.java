package com.jihwi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                //뒤에 / 꼭 붙여줘야함. 안그럼 맵핑 오류 날 수 있음.
                .addResourceLocations("classpath:/m/")
                //20초 초단위임
                .setCachePeriod(20);
    }
}
