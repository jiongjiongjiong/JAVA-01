package com.zc.week08.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_order")
@Data
public class OrderEntity {
    @Id
    private Long orderNo;
    private Long userId;
    private String mobile;
    private Long totalAmount;
    private Integer goodsNumber;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime finishTime;
    private LocalDateTime closeTime;
}
