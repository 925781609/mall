package com.liuil.web.controller;

import com.liuil.web.service.UserService;
import com.liuil.web.util.UserContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        logger.warn("username:" + username + "  " + "password:" + password);
        System.out.println(username+ " " + password);
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
  public String logout(){
    if(session.getAttribute(UserContext.USER_NAME) != null){
      session.removeAttribute(Const.USER_NAME);
      return "redirect:/" ;
    }
  }


  @GetMapping("register")
  public String registerForm(){
    //instantiate an RegisterForm object
      RegisterForm registerForm = new RegisterForm();

    //add it to the model
    model.addAttribute("registerForm", registerForm);

    //get out
    return "register";
  }

  @PostMapping("register")
  public String registerUserAccount(@ModelAttribute("registerForm") @Valid RegisterForm registerForm,
                                                BindingResult result){
      userService.register(registerForm, result)

      if (result.hasErrors()){
        return "registration";
      }

      userService.save(registerForm);
      return "redirect:/registration?success";
  }

}
