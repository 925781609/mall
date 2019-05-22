package com.liuil.xmall.service.impl;

import com.liuil.xmall.common.util.IdGenerateUtils;
import com.liuil.xmall.controller.UserController;
import com.liuil.xmall.domain.RegisterForm;
import com.liuil.xmall.domain.User;
import com.liuil.xmall.mapper.UserDao;
import com.liuil.xmall.service.UserService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserServiceImpl implements UserService {

  public static Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  private UserDao userDao;

  // 暂时login使用最简单的方式实现
  @Override
  public boolean login(String username, String password) {
    if ("username".equals(username) && "password".equals(password)) {
      logger.debug(
          "true In UserServiceImpl:" + "username -" + username + " " + "password - " + password);
      return true;
    } else {
      logger.debug(
          "false In UserServiceImpl:" + "username -" + username + " " + "password - " + password);
      return false;
    }
  }

  @Override
  public void register(RegisterForm registerForm, BindingResult result) {
    logger.debug("In register ");
    //User existing = userService.findByEmail(registerForm.getEmail());
    String existing = "test";
    if (existing != null) {
      result.rejectValue("email", null, "There is already an account registered with that email");
    }
  }

  @Override
  public User findByEmail(String email) {
    return userDao.findByEmail(email);
  }

  @Override
  public void save(RegisterForm registerForm) {
  }

  ;


  @Override
  public int batchAddUsers(List<User> users) {
    for (User user : users) {
      user.setUserId(IdGenerateUtils.getUserId());
      userDao.save(user);
    }
    return 1;
  }

  @Override
  public List<User> getUsers() {
    return userDao.getUsers();
  }
}
