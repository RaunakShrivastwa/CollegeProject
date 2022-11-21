package com.Employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiantController {

    @GetMapping("/denied")
    public String denied(){
        return "denied";
    }

    @GetMapping("/contact")
    public String contact(){
        return "denied";
    }
}
