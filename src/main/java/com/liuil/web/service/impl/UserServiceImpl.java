package com.liuil.web.service.impl;

import com.liuil.web.controller.UserController;
import com.liuil.web.domain.RegisterForm;
import com.liuil.web.domain.User;
import com.liuil.web.mapper.UserDao;
import com.liuil.web.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.apache.commons.codec.digest.DigestUtils;


@Service
public class UserServiceImpl implements UserService {
  public static Logger logger = Logger.getLogger(UserController.class);

  @Autowired
  private UserDao userDao;

  // 暂时login使用最简单的方式实现
  public boolean login(String username, String password){
    md5Password = userDao.selectPasswordByUsername()
    if(md5Password ==  null){
      logger.debug("用户不存在");
      return false;
    }
    else{
        retrun md4Password.equals(DigestUtils.md5Hex(password))
      logger.debug("true In UserServiceImpl:"+ "username -" + username + " " + "password - " + password);
    }
  }
  public void register(RegisterForm registerForm, BindingResult result){
    logger.debug("In register ");
    User existing = userDao.findByEmail(registerForm.getEmail());
    if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
    }
    save(resgiterFomr);
    // SendEmail,在另外email中奖confirmed为1
  }

  public void save(RegisterForm registerForm) {
      user = User(regisertForm.getUsername());
      user.setUsername(registerForm.getUsername());
      user.setPassword(DigestUtils.md5Hex(registerForm.getPassword()));
      user.setEmail(registerForm.getEmail());
      user.setPhone(registerForm.getPhone());
      return userDao.save(user);

  }
}
