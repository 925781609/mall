package com.liuil.xmall.mapper;

import com.liuil.xmall.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserDao extends BaseDao<User> {

  User findByEmail(@Param("email") String email);

  List<User> getUsers();

}
