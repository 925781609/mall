package com.liuil.xmall.mapper;

import com.liuil.xmall.domain.Order;
import com.liuil.xmall.domain.OrderDetails;
import com.liuil.xmall.domain.OrderRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao extends BaseDao<Order> {

  List<Order> getOrders(@Param("e") OrderRequest orderRequest);

  List<OrderDetails> getOrderDetails(@Param("e") OrderRequest orderRequest);

}
