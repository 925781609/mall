package com.liuil.web.service.impl;

import com.liuil.web.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  // 暂时login使用最简单的方式实现
  public boolean login(String username, String password){
    if(username=="name" && password=="password"){
      return true;
    }
    else{
      return false;
    }
  }
}
