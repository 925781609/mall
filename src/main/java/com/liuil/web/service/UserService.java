package com.liuil.web.service;


public interface UserService {
  public boolean login(String username, String password);

  public void register(RegisterForm registerForm, BindingResult result);

  public void save(RegisterForm registerForm);

  public User findByEmail(String email)
}
