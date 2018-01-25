package com.liuil.web.service;

import com.liuil.web.domain.RegisterForm;
import com.liuil.web.domain.User;
import org.springframework.validation.BindingResult;

public interface UserService {
  public boolean login(String username, String password);

  public void register(RegisterForm registerForm, BindingResult result);

  public User findByEmail(String email);

  public int save(RegisterForm registerForm);
}
