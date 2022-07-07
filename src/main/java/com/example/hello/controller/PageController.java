package com.example.hello.controller;

import com.example.hello.controller.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user() {
        // var 타입추론 여기서 이게 왜...
        var user = new User();
        user.setName("steve");
        user.setAddress("fastcampus");
        user.setAge(10);
        user.setPhoneNumber("010-1111-2222");
        return user;
    }
}
