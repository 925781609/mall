package com.liuil.xmall.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetails {
    private Long orderId;
    private Integer userId;
    private Integer orderItemId;
    private String orderDescription;
    private String orderItemDescription;
    private Date createTime;
}
