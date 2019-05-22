package com.liuil.xmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// mapper 接口类扫描包配置
@SpringBootApplication
@MapperScan("com.liuil.xmall.mapper")
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }
}
