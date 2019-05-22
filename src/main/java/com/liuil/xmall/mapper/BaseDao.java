package com.liuil.xmall.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {

  int save(@Param("e") T e);

  int batchSave(@Param("l") List<T> l);

}
