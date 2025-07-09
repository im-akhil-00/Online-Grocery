package com.crio.onlineGrocery.service;

import com.crio.onlineGrocery.dto.OrderDto;
import com.crio.onlineGrocery.model.OrderEntity;
import com.crio.onlineGrocery.repository.IgroceryItemrepository;
import com.crio.onlineGrocery.repository.IorderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {
    @Autowired
    IorderRepository iorderRepository;
    @Autowired
    ModelMapper modelMapper;

    public OrderEntity save(OrderDto orderDto)
    {
        OrderEntity orderEntity=modelMapper.map(orderDto,OrderEntity.class);
        return iorderRepository.save(orderEntity);
    }

    public List<OrderEntity> getOrders()
    {
        return iorderRepository.findAll();
    }

    public OrderEntity getOrderById(Long Id)
    {
        return iorderRepository.findById(Id).orElseThrow(()->new RuntimeException("order not found with Id "+Id));
    }

    public void delete(Long Id)
    {
        iorderRepository.deleteById(Id);
    }

    public OrderEntity updateOrder(Long Id,OrderDto orderDto)
    {
        OrderEntity orderEntity=getOrderById(Id);
        modelMapper.map(orderDto,orderEntity);
        return iorderRepository.save(orderEntity);
    }

}
