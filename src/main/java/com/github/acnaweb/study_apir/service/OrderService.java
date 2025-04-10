package com.github.acnaweb.study_apir.service;

import com.github.acnaweb.study_apir.dto.OrderRequestCreate;
import com.github.acnaweb.study_apir.dto.OrderRequestUpdate;
import com.github.acnaweb.study_apir.model.Order;
import com.github.acnaweb.study_apir.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderRequestCreate dto){
        return orderRepository.save(dto.toModel());
    }
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    public Optional<Order> updateOrder(Long id, OrderRequestUpdate dto){
    return orderRepository.findById(id)
            .map(o-> orderRepository.save(dto.toModel(o)));
    }
    public boolean deleteOrder(Long id){
    if(orderRepository.existsById(id)){
        orderRepository.deleteById(id);
        return true;
    }
        return false;
    }
}
