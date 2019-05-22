package com.liuil.xmall.service.impl;


import com.liuil.xmall.common.util.IdGenerateUtils;
import com.liuil.xmall.domain.Order;
import com.liuil.xmall.domain.OrderDetails;
import com.liuil.xmall.domain.OrderItem;
import com.liuil.xmall.domain.OrderRequest;
import com.liuil.xmall.domain.OrderVo;
import com.liuil.xmall.mapper.OrderDao;
import com.liuil.xmall.mapper.OrderItemDao;
import com.liuil.xmall.service.OrderService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  OrderDao orderDao;

  @Autowired
  OrderItemDao orderItemDao;

  @Override
  public int save(OrderVo orderVo) {
    Order order = orderVo.getOrder();
    List<OrderItem> orderItems = orderVo.getOrderItems();
    addSnowId(order, orderItems);
    orderItemDao.batchSave(orderItems);
    return orderDao.save(order);

  }

  @Override
  public List<Order> getOrders(OrderRequest orderRequest) {
    return orderDao.getOrders(orderRequest);
  }

  private void addSnowId(Order order, List<OrderItem> orderItems) {
    Long snowId = IdGenerateUtils.getSnowId();
    order.setOrderId(snowId);
    Optional.ofNullable(orderItems).orElse(Collections.emptyList())
        .stream().forEach(e -> e.setOrderId(snowId));
  }

  @Override
  public List<OrderDetails> getOrderDetails(OrderRequest orderRequest) {
    return orderDao.getOrderDetails(orderRequest);
  }
}
