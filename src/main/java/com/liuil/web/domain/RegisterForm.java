package com.liuil.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm{
    @NotNull(message="请输入用户名")
    @Size(min=5, max=30, message="最少5位，最大不能超过30位")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,29}$", message="用户名只能包含英文字母、数字及“_”，必须以英文字母开头")
    private String username;

    @NotNull(message="请输入邮箱")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message="邮箱格式不正确")
    private String email;

    @NotNull(message="请输入手机号码")
    @Pattern(regexp = "^1[0-9]{10}$", message="手机号码格式不正确")
    private String phone;

    @NotNull(message="请输入密码")
    @Size(min=5, max=50, message="最少5位，最大不能超过50位")
    @Pattern(regexp = "^[a-zA-z!@#$%^&*]{5,50}$", message="密码可以是数字、字母或者!@#$%^&*")
    private String password;

    @NotNull(message="请再次输入密码")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]{4,49}$", message="密码可以是数字或者字母")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
