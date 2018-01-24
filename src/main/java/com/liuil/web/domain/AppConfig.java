package com.liuil.web.domain;

import com.liuil.web.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

  @Autowired
  LoginInterceptor loginInterceptor;

  // 多个拦截器组成一个拦截器链
  // addPathPatterns 用于添加拦截规则
  // excludePathPatterns 用户排除拦截
  // registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
  @Override
  public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(loginInterceptor);
  }
}
