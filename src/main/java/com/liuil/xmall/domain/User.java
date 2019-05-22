package com.liuil.xmall.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private int id;  // 自增ID
  private String name; // 用户名
  private int userId;
  private int age;
  private String address;
  private String password; // 用户密码(MD5加密)
  private String email; // 邮箱(唯一)
  private String phone; // 手机号(唯一)
  private int role; // 角色 0-管理员， 1-普通用户
  private boolean confirmed; // 是否通过邮箱验证
  private boolean activate; // 用户是否有效
  private Date createTime; // 创建时间
  private Date modifiedTime; // 更新时间
}
