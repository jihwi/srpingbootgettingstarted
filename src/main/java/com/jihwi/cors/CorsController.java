package com.jihwi.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8090")
/***
 * crossOrgin 애너테이션은 @Target({ElementType.METHOD, ElementType.TYPE}) 메소드와 객체에 가능함.
 * 전범위 프로젝트에 적용하고 싶다면 webConfig에서  addCorsMappings 구현 하면됨.
 */
public class CorsController {


    @GetMapping("/cors")
    public String cors(){
        return "welocome cors";
    }
}
