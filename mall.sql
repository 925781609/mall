-- ----------------------------
--  用户表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `role` int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
  `confirmed` BOOLEAN DEFAULT FALSE COMMENT '邮箱验证',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE,
  UNIQUE KEY `email_unique` (`email`) USING BTREE,
  UNIQUE KEY `phone_name_unique` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;