package com.liuil.xmall.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties(prefix = "com.liuil.xmall")
@PropertySource("classpath:helloworld.properties")
public class ConfigBean{
  private String greeting;
  private String content;

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
