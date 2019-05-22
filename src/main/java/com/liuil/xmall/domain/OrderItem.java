package com.liuil.xmall.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private Long orderId;
    private Integer orderItemId;
    private Integer userId;
    private String description;
}
