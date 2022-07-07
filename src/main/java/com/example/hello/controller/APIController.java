package com.example.hello.controller;

import com.example.hello.controller.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 이 class 는 Rest API 를 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI 를 지정해주는 Annotation
public class APIController {
    @GetMapping("/hello") // http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    /////////////////////////////////////////////////////////////////// ABOUT RESPONSE

    //TEXT
    @GetMapping(path = "/text")
    public String text(@RequestParam String account) {
        System.out.println(account);
        return account;
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping(path = "/json")
    public User json(@RequestBody User user) {
        return user; // 200 OK
    }

    // ResponseEntity
    @PutMapping(path = "/put")
    // @ResponseStatus(HttpStatus.CREATED) // made by chlgml
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
        // return user; // made by chlgml
    }

}
