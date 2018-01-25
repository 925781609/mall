package com.liuil.web.mapper;

import com.liuil.web.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
  String selectPasswordByUsername(String username)
  User findByEmail(@Param("email") String email);
  int insert(User user) throw Exception;
}
