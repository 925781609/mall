package com.liuil.web.controller;


import com.liuil.web.domain.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @Autowired
  ConfigBean configBean;

  @RequestMapping("/hello")
  public String greeting(){
      return configBean.getGreeting() + ", " + configBean.getContent();
  }

}
