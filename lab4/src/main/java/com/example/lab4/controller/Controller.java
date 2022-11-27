package com.example.lab4.controller;

import com.example.lab4.annotations.ExcecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controller {


    @GetMapping("/method1")
    @ExcecutionTime
    public String getMethodOne(){
        System.out.println("from method one");
        return "from method 1";

    }

    @GetMapping("/method2")
    @ExcecutionTime
    public String getMethodTwo(){
        System.out.println("from method two");
        return "from method two";

    }

}
