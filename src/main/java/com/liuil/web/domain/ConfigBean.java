package com.liuil.web.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "com.liuil.web")
@PropertySource("classpath:helloworld.properties")
public class ConfigBean{
  private String greeting;
  private String content;

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}


@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{

    @Autowired
    LoginInterceptor loginInterceptor;


    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    // registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor);
    }
}
