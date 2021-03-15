package com.zc.week08.controller;

import com.zc.week08.entity.OrderEntity;
import com.zc.week08.request.ReqOrderSave;
import com.zc.week08.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/save")
    public String save(@RequestBody ReqOrderSave reqOrderSave){
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(reqOrderSave, entity);
        entity.setCreateTime(LocalDateTime.now());
        orderService.save(entity);
        return "success";
    }

    @GetMapping(value = "/query")
    public List<OrderEntity> findAll(){
        return orderService.findAll();
    }
}
