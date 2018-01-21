package com.liuil.web.controller;

import com.liuil.web.domain.ConfigBean;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableConfigurationProperties(ConfigBean.class)
public class HelloWorldController {

  @Autowired
  ConfigBean configBean;
  @ModelAttribute(value = "message")
  public String addMessage(@RequestParam(required = false) String abc){
    if(abc == null){
      return "default";
    }
    else{
      return abc;
    }
  }

  @RequestMapping("/")
  public String welcome(Map<String, Object> model){
      String message = configBean.getGreeting() + ", " + configBean.getContent();
      // model.put("message", message); # 上面的可以实现相同的功能
      // return 的是template的名字
      return "index";
  }

}
