package com.liuil.web.mapper;

import com.liuil.web.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
  User findByEmail(@Param("email") String email);
}
