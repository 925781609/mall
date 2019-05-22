package com.liuil.xmall.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderVo {
    private Order order;
    private List<OrderItem> orderItems;
}
