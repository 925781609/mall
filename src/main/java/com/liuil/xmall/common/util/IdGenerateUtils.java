package com.liuil.xmall.common.util;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;

public class IdGenerateUtils {

  public static DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
  private static Integer id = 0;

  //FIXME: 为了学习分库分表，才使用的这种id生成方式
  public static synchronized int getUserId() {
    return ++id;
  }

  public static long getSnowId() {
    return keyGenerator.generateKey().longValue();
  }
}
