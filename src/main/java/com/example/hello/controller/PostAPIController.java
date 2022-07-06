package com.example.hello.controller;

import com.example.hello.controller.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/post-api") // 강의와 다르게 한 이유... 레포파기 귀찮
public class PostAPIController {

    @PostMapping(path = "/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        // @RequestBody : Body 를 사용하는 요청에서 Body 의 json 에 대응 시킬 때 사용
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    @PostMapping(path = "/post-use-dto")
    public void post_use_dto(@RequestBody PostRequestDto postRequestDto) {
        System.out.println(postRequestDto);
    }

    @PostMapping(path = "/use-pathVariable/{qaa}")
    public void usePv(@PathVariable(name = "qaa") String id) {
        System.out.println(id);
    }
}
