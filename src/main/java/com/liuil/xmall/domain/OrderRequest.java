package com.liuil.xmall.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

  // 用户id
  private Integer userId;
  // order_id起始值
  private Long start;
  // order_id结束值
  private Long end;
  // 订单起始时间
  private String startTime;
  // 订单结束时间
  private String endTime;
}
