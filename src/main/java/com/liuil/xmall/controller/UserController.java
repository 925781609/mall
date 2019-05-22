package com.liuil.xmall.controller;

import com.liuil.xmall.common.util.UserContext;
import com.liuil.xmall.domain.RegisterForm;
import com.liuil.xmall.domain.User;
import com.liuil.xmall.service.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "user")
public class UserController {

  // 定义一些模板常量
  public final static String LOGIN = "index";
  public static Logger logger = Logger.getLogger(UserController.class);
  @Autowired
  private UserService userService;


  // 登录
  @GetMapping(value = "login")
  public String loginPage(HttpSession session) {
    logger.info("info");
    logger.warn("warning");
    if (session.getAttribute(UserContext.USER_NAME) != null) {
      return "redirect:/";
    }
    return "login";
  }

  @PostMapping(value = "login")
  public String login(@RequestParam("username") String username,
      @RequestParam("password") String password,
      HttpSession session) {
    try {
      if (userService.login(username, password)) {
        logger.warn("in login put method");
        logger.warn("username:" + username + "  " + "password:" + password);
        System.out.println(username + " " + password);
        session.setAttribute(UserContext.USER_NAME, username);
        return "redirect:/";
      } else {
        return LOGIN;
      }
    } catch (Exception e) {
      return LOGIN;
    }
  }

  @PostMapping("logout")
  public String logout(HttpSession session) {
    if (session.getAttribute(UserContext.USER_NAME) != null) {
      session.removeAttribute(UserContext.USER_NAME);
      return "redirect:/";
    } else {
      return "login";
    }
  }


  @GetMapping("register")
  public String registerForm(RegisterForm registerForm) {
    //instantiate an RegisterForm object

    //add it to the model
    //model.addAttribute("registerForm", registerForm);

    //get out
    return "register";
  }

  @PostMapping("register")
  public String registerUserAccount(@Valid RegisterForm registerForm,
      BindingResult result) {
    userService.register(registerForm, result);

    if (result.hasErrors()) {
      return "register";
    }

    userService.save(registerForm);
    return "redirect:/registration?success";
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<User> getUsers() {
    return userService.getUsers();
  }
}
