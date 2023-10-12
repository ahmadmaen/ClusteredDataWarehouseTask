package ProgressSoft.example.ClusteredDataWarehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") // Specify a base path for the controller
public class TestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello-world";
    }
}