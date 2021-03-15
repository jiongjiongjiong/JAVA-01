package com.zc.week08.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: zhangc
 * @date: 2021/3/15
 * @desc:
 */
@Data
public class ReqOrderSave {
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
