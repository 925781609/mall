package com.liuil.xmall;

import com.alibaba.fastjson.JSON;
import com.liuil.xmall.common.util.DateUtils;
import com.liuil.xmall.domain.Order;
import com.liuil.xmall.domain.OrderDetails;
import com.liuil.xmall.domain.OrderRequest;
import com.liuil.xmall.domain.OrderVo;
import com.liuil.xmall.service.OrderService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceImpl Tester.
 *
 * @author <AVuthors name>
 * @version 1.0
 * @since <pre>���� 20, 2019</pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

  @Autowired
  OrderService orderService;

  @Test
  public void testBatchAddUsers() throws Exception {
    String input = "[{\n"
        + "    \"order\":{\n"
        + "        \"userId\":1,\n"
        + "        \"description\":\"No1 order 2019-05-21\"\n"
        + "    },\n"
        + "    \"orderItems\":[\n"
        + "        {\n"
        + "            \"orderItemId\":1,\n"
        + "            \"userId\":1,\n"
        + "            \"description\":\"big tv\"\n"
        + "        },{\n"
        + "            \"orderItemId\":2,\n"
        + "            \"userId\":1,\n"
        + "            \"description\":\"beautiful air_conditioner\"\n"
        + "        },{\n"
        + "            \"orderItemId\":5,\n"
        + "            \"userId\":1,\n"
        + "            \"description\":\"suitable desk\"\n"
        + "        }    \n"
        + "    ]\n"
        + "}\n"
        + "\n"
        + "{\n"
        + "    \"order\":{\n"
        + "        \"userId\":4,\n"
        + "        \"description\":\"No2 order 2019-05-21\"\n"
        + "    },\n"
        + "    \"orderItems\":[\n"
        + "        {\n"
        + "            \"orderItemId\":4,\n"
        + "            \"userId\":4,\n"
        + "            \"description\":\"comfortable sofa\"\n"
        + "        },{\n"
        + "            \"orderItemId\":6,\n"
        + "            \"userId\":4,\n"
        + "            \"description\":\"good wine\"\n"
        + "        },{\n"
        + "            \"orderItemId\":7,\n"
        + "            \"userId\":4,\n"
        + "            \"description\":\"plate\"\n"
        + "        },{\n"
        + "            \"orderItemId\":8,\n"
        + "            \"userId\":4,\n"
        + "            \"description\":\"useful book\"\n"
        + "        }    \n"
        + "    ]\n"
        + "}]";

    List<OrderVo> orderVos = JSON.parseArray(input, OrderVo.class);

    orderService.save(orderVos.get(0));
    orderService.save(orderVos.get(1));
  }

  @Test
  public void testGetOrders() {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.setUserId(1);
    String startTime = "2019-05-01";
    String endTime = "2019-05-30";
    String pattern = "yyyy-MM-dd";
    // 因为sharding-column=order_id 所以需要把startTime和endTime转为shardingkey，否则会全表全路由
    Long start = DateUtils.stringDateToShardingKey(startTime, pattern);
    Long end = DateUtils.stringDateToShardingKey(endTime, pattern);
//    orderRequest.setStart(start);
//    orderRequest.setEnd(end);
    List<Order> result = orderService.getOrders(orderRequest);
    System.out.println(result);

  }

  @Test
  public void testGetDetails() {
    OrderRequest orderRequest = new OrderRequest();
    orderRequest.setUserId(1);
    String startString = "2019-05-01";
    String endString = "2019-05-30";
    orderRequest.setStartTime(startString);
    orderRequest.setEndTime(endString);
    String pattern = "yyyy-MM-dd";
    List<OrderDetails> result = orderService.getOrderDetails(orderRequest);
    System.out.println(result);

  }


} 
