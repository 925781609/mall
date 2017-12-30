package com.liuil.web;

import com.liuil.web.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// 不太确定以下两个注解的作用，没有这两个注解， 测试也能正常进行
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HelloWorldControllerTests {
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception{
    mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
  }

  @Test
  public void getHello() throws Exception{
    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
  }


}
