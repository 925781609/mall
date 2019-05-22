package com.liuil.xmall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
  //public static Logger logger = Logger.getLogger(LoginInterceptor.getClass());

  @Override
  public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception{
    //logger.info("preHandler is called");
    return true;
  }

}
