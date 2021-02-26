## 学习笔记

## 作业
2.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交DDL的SQL文件到Github（后面2周的作业依然要是用到这个表结构）。


```
CREATE TABLE `t_user` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `mobile` VARCHAR(20) DEFAULT '' COMMENT '手机号',
    `nickname` VARCHAR(32) DEFAULT '' COMMENT '昵称',
    `password` VARCHAR(32) DEFAULT '' COMMENT '密码',
    `create_time` DATETIME COMMENT '创建时间',
    `status` TINYINT(1) DEFAULT 0 COMMENT '状态，0：启用，1：停用',
    PRIMARY KEY(`id`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT '用户基本信息表';

CREATE TABLE  `t_goods` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL COMMENT '商品名称',
    `price` BIGINT(20) NOT NULL COMMENT '商品价格，单位：分',
    `desc` VARCHAR(255) DEFAULT '' COMMENT '商品描述',
    `images` VARCHAR(512) DEFAULT '' COMMENT '商品图片', 
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '修改时间',
    `status` TINYINT(1) DEFAULT 0 COMMENT '状态，0：启用，1：停用',
     PRIMARY KEY(`id`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT '商品基本信息表';


CREATE TABLE  `t_order` (
    `order_no` VARCHAR(32) NOT NULL COMMENT '订单号',
    `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
    `mobile` VARCHAR(20) NOT NULL COMMENT '用户手机',
    `total_amount` BIGINT(20) NOT NULL COMMENT '商品总价格，单位：分',
    `goods_number` INT NOT NULL COMMENT '商品数量',
    `status` TINYINT(1) DEFAULT 1 COMMENT '订单状态，1 待付款 2 待发货 3 待收货 4 已完成 5 已关闭',
    `create_time` DATETIME COMMENT '下单时间',
    `pay_time` DATETIME COMMENT '支付时间',
    `delivery_time` DATETIME COMMENT '发货时间',
    `finish_time` DATETIME COMMENT '完成时间',
    `close_time` DATETIME COMMENT '关闭时间',
    PRIMARY KEY(`order_no`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT '订单表';

CREATE TABLE  `t_order_detail` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `order_no` VARCHAR(32) NOT NULL COMMENT '订单号',
    `goods_id` BIGINT(20) NOT NULL COMMENT '商品id',
    `goods_name` VARCHAR(64) NOT NULL COMMENT '商品名称',
    `goods_price` BIGINT(20) NOT NULL COMMENT '商品价格，单位：分',
    `goods_number` INT NOT NULL COMMENT '商品数量',
    `create_time` DATETIME COMMENT '创建时间',
    `update_time` DATETIME COMMENT '修改时间',
    PRIMARY KEY(`id`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT '订单详情表';
```