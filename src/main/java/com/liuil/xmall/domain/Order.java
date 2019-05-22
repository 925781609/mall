package com.liuil.xmall.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

  private Long orderId;
  private Integer userId;
  private String description;
  private Date createTime;
}
