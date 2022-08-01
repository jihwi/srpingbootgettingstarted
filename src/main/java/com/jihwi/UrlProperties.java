package com.jihwi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@ConfigurationProperties("url.custom")
@Validated
public class UrlProperties {
    @NotBlank
    private String image;
    private String web;

//    @DurationUnit(ChronoUnit.MILLIS)
    //surfix만 잘 쓰면 이 애너테이션 표시 안해줘 도 됨 ms (miliseconds) s (seconds )등
    private Duration connectionTimeout = Duration.ofMillis(3000);

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Duration getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Duration connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
