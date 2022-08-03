package com.jihwi.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exception")
    public String exception(){
        throw new SampleException();
    }

    //sampleException이 발생할 경우  exceptionhandler가 작동하여 아래 메소드를 실행한다.
    @ExceptionHandler(SampleException.class)
    public @ResponseBody SampleError sampleError(SampleException e){
        SampleError error = new SampleError();
        error.setMsg("error.sample.key");
        error.setReason("IDK");
        return error;
    }

    //500에러 구현
    /**
     * @Controller
     * @RequestMapping({"${server.error.path:${error.path:/error}}"})
     * public class BasicErrorController extends AbstractErrorController {
     *
     * 즉 server.error.path가 따로 지정되어 있지 않은 경우, error 하위의 에러코드 뷰 리턴 (404/ 4xx/ 5xx)
     * **/

    @GetMapping("/runtime")
    public String runtime(){
        throw new RuntimeException();
    }
}
