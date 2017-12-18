package com.liuil.controller;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloController {

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello, My World!";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(HelloController.class, args);
  }
}
