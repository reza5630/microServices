package com.miu.cs.restfulweb.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    String helloWorld(){
        return "hello world";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    Person helloWorldBean(@PathVariable String name){
        return new Person(name);
    }
}
