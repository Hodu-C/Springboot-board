package com.melog.melog.domain;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;

@RestController
public class HomeController {
    @RequestMapping(value="/home")
    public String home() {
        String result = "{data:nhsadbiasdf}";
        return result;
    }
//
//    @Scope("")
//    public ArrayList<Object> response() {
//        // 요청전 미들웨어 실행
//        // 실제로 컨트롤러 실행
//        controloer = home();
//        // 요청후 미들웨어 실행
//        return { status: 200, data: controller }
//    }
}
