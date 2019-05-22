package com.liuil.xmall.service;

import com.liuil.xmall.domain.Order;
import com.liuil.xmall.domain.OrderDetails;
import com.liuil.xmall.domain.OrderRequest;
import com.liuil.xmall.domain.OrderVo;
import java.util.List;

public interface OrderService extends BaseService<OrderVo> {

  List<Order> getOrders(OrderRequest orderRequest);

  List<OrderDetails> getOrderDetails(OrderRequest orderRequest);

}
