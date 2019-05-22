package com.liuil.xmall;

import com.alibaba.fastjson.JSON;
import com.liuil.xmall.domain.User;
import com.liuil.xmall.service.UserService;
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
public class UserServiceTest {

  @Autowired
  UserService userService;

  @Test
  public void testBatchAddUsers() throws Exception {
    String input = "[\n"
        + "        {\n"
        + "            \"name\":\"Jack\",\n"
        + "            \"age\":11,\n"
        + "            \"address\":\"Street One\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Bob\",\n"
        + "            \"age\":12,\n"
        + "            \"address\":\"Street Two\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Jessy\",\n"
        + "            \"age\":13,\n"
        + "            \"address\":\"Street Three\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Jim\",\n"
        + "            \"age\":14,\n"
        + "            \"address\":\"Street Four\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Lucy\",\n"
        + "            \"age\":15,\n"
        + "            \"address\":\"Street Five\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Lily\",\n"
        + "            \"age\":16,\n"
        + "            \"address\":\"Street Six\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"Ben\",\n"
        + "            \"age\":17,\n"
        + "            \"address\":\"Street Seven\"\n"
        + "        },\n"
        + "        {\n"
        + "            \"name\":\"John\",\n"
        + "            \"age\":18,\n"
        + "            \"address\":\"Street Eight\"\n"
        + "        }\n"
        + "    ]";

    List<User> users = JSON.parseArray(input, User.class);

    userService.batchAddUsers(users);

  }


} 
