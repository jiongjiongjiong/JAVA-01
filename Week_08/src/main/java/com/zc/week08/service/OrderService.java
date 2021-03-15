package com.zc.week08.service;

import com.zc.week08.entity.OrderEntity;
import com.zc.week08.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(OrderEntity entity){
        orderRepository.save(entity);
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }
}
