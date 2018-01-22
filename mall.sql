-- ----------------------------
--  用户表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` unsigned int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `role` unsigned int(4) NOT NULL COMMENT '角色0-管理员,1-普通用户',
  `is_confirmed` unsigned tinyint DEFAULT 0 COMMENT '邮箱验证',
  `is_active` unsigned tinyint DEFAULT 0 COMMENT '用户是否有效',
  `gmt_create`   datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE,
  UNIQUE KEY `email_unique` (`email`) USING BTREE,
  UNIQUE KEY `phone_name_unique` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
