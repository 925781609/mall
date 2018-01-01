package com.liuil.web.controller;

import com.liuil.web.domain.ConfigBean;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableConfigurationProperties(ConfigBean.class)
public class HelloWorldController {

  @Autowired
  ConfigBean configBean;


  @RequestMapping("/hello")
  public String welcome(Map<String, Object> model){
      String message = configBean.getGreeting() + ", " + configBean.getContent();
      model.put("message", message);
      // return 的是template的名字
      return "welcome1";
  }

}
