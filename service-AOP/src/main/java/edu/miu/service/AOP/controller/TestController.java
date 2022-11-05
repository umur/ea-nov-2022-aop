package edu.miu.service.AOP.controller;

import edu.miu.service.AOP.aspect.annotation.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @ExecutionTime
    @PostMapping
    public boolean postTestMetohd(){
        return true;
    }


    @ExecutionTime
    @GetMapping
    public boolean getTestMethod(){
        return true;
    }
}
