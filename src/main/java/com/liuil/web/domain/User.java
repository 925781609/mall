package com.liuil.web.domain;

import java.util.Date;

public class User {
  private int id;  // 自增ID
  private String username; // 用户名
  private String password; // 用户密码(MD5加密)
  private String email; // 邮箱(唯一)
  private String phone; // 手机号(唯一)
  private int   role; // 角色 0-管理员， 1-普通用户
  private boolean confirmed; // 是否通过邮箱验证
  private boolean activate; // 用户是否有效
  private Date createTime; // 创建时间
  private Date modifiedTime; // 更新时间

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


}
