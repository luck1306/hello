package com.example.hello.controller;

import com.example.hello.controller.dto.UserRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetAPIController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String Hello() {
        return "get hello";
    }
// 옛날에 쓰던 방식 ↓
    @RequestMapping(path = "hi", method = RequestMethod.GET) // GET http://localhost:9090/api/get/hi
    public String Hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{var}")
    public String pathVariable(@PathVariable(name = "var") String path_variable) {
// 어노테이션 PathVariable 의 name 은 매핑된 경로의 중괄호로 감싸져 있는 값을 할당할 수 있고,
// 이를 통해 method 의 매개변수의 이름으로 경로에 있는 값과 다르게 이름지을 수 있다.
        System.out.println("PathVariable : " + path_variable);
        return path_variable;
    }

    // http://localhost:9090/api/get/query-param?key1=value1&key2=value2&key3=value3
    @GetMapping(path = "/query-param") // 매개로 받을 값이 몇 개일지 모를 때 사용하는 방법
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuffer sb = new StringBuffer();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }

    @GetMapping(path = "/query-param02") // 받아올 매개를 정확히 알 때 사용하는 방법1, 위 코드 보다 훨씬 더 알기 쉽다.
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println("Query(name) : value ... " + name);
        System.out.println("Query(email) : value ... " + email);
        System.out.println("Query(age) : value ... " + age);
        return name + " " + email + " " + age;
    }

    @GetMapping(path = "/query-param03") // 받아올 매개를 정확히 알 때 사용하는 방법2, 대부분이 이렇게 사용함,
    // 정보 : 같은 경로로 dto 이름의 패키지가 존재하며,
    // 그 안에 private 필드로 받아올 매개 값의 키와 같은 필드가 존재, 필드마다 Getter, Setter 존재
    public String queryParam03(UserRequest userRequest) {
        System.out.println("Query(name) : value ... " + userRequest.getName());
        System.out.println("Query(email) : value ... " + userRequest.getEmail());
        System.out.println("Query(age) : value ... " + userRequest.getAge());

        return userRequest.toString();
    }

}
