package com.liuil.xmall.service;

import com.liuil.xmall.domain.RegisterForm;
import com.liuil.xmall.domain.User;
import java.util.List;
import org.springframework.validation.BindingResult;

public interface UserService {

  boolean login(String username, String password);

  void register(RegisterForm registerForm, BindingResult result);

  void save(RegisterForm registerForm);

  User findByEmail(String email);

  int batchAddUsers(List<User> users);

  List<User> getUsers();

}
