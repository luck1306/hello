package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/delete-api")
public class DeleteAPIController {

    @DeleteMapping(path = "/delete/{userId}")
    public void delete(@PathVariable(name = "userId") long pathValue, @RequestParam(value = "account") String value) {
        System.out.println(pathValue);
        System.out.println(value);
        return;
    }
}
