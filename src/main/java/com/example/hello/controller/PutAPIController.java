package com.example.hello.controller;

import com.example.hello.controller.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/put-api")
public class PutAPIController {

    @PutMapping("/put")
    public void put(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

    @PutMapping("/p")
    public PutRequestDto p(@RequestBody PutRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/{userId}")
    public String putPv(@PathVariable(name = "userId") String a) {
        System.out.println(a);
        return a;
    }
}
