package com.example.data.JPAdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/public")
    public String login(){
        return "Authentication";
    }
    //only authorized user can access
    @GetMapping("/private")
    public String log(){
        return "Authorization";
    }
}
