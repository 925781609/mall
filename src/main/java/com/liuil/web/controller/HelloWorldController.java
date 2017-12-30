package com.liuil.web.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  @Value("${com.liuil.greeting}")
  private String greeting;
  @Value("${com.liuil.content}")
  private String content;

  @RequestMapping("/hello")
  public String greeting(){
      return greeting + ", " + content;
  }

}
