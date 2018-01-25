package com.liuil.web.controller;

import com.liuil.web.service.UserService;
import com.liuil.web.util.UserContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.liuil.web.util.UserContext;
import com.liuil.web.domain.RegisterForm;

@Controller
@RequestMapping(value="user")
public class UserController {
  public static Logger logger = Logger.getLogger(UserController.class);
  // 定义一些模板常量
  public final static String LOGIN = "index";

  @Autowired
  private UserService userService;


  // 登录
  @GetMapping(value="login")
  public String loginPage(HttpSession session){
    logger.info("info");
    logger.warn("warning");
    if(session.getAttribute(UserContext.USER_NAME) != null){
      return "redirect:/" ;
    }
    return "login";
  }

  @PostMapping(value = "login")
  public String login(@RequestParam ("username") String username,
                       @RequestParam("password") String password,
                       HttpSession session){
    try{
      if(userService.login(username, password)){
        logger.warn("in login put method");
        session.setAttribute(UserContext.USER_NAME, username);
        return "redirect:/";
      }
      else{
        return LOGIN;
      }
    } catch (Exception e){
      return LOGIN;
    }
  }

  @PostMapping("logout")
  public String logout(HttpSession session){
    if(session.getAttribute(UserContext.USER_NAME) != null){
      session.removeAttribute(UserContext.USER_NAME);
      return "redirect:/" ;
    }
    else{
      return "login";
    }
  }


  @GetMapping("register")
  public String registerForm(RegisterForm registerForm){
    //instantiate an RegisterForm object

    //add it to the model
    //model.addAttribute("registerForm", registerForm);

    //get out
    return "register";
  }

  @PostMapping("register")
  public String registerUserAccount(@Valid RegisterForm registerForm,
                                                BindingResult result){
      userService.register(registerForm, result);

      if (result.hasErrors()){
        return "register";
      }

      return "redirect:/registration?success";
  }
}
