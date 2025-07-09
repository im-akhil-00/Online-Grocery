package com.crio.onlineGrocery.controller;

import com.crio.onlineGrocery.dto.CustomerDto;
import com.crio.onlineGrocery.dto.OrderDto;
import com.crio.onlineGrocery.model.CustomerEntity;
import com.crio.onlineGrocery.model.OrderEntity;
import com.crio.onlineGrocery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private static final String OrdersAPI="/getOrders";
    private static final String saveCustomerAPI="/saveOrder";
    private static final String updateCustomerAPI="/updateOrder";
    private static final String deleteCustomerAPI="/deleteOrder";
    @Autowired
    OrderService orderService;

    @GetMapping(OrdersAPI)
    public ResponseEntity<List<OrderEntity>> getOrders()
    {
        List<OrderEntity> orderEntities=orderService.getOrders();
        return ResponseEntity.ok().body(orderEntities);
    }

    @PostMapping(saveCustomerAPI)
    public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderDto orderDto)
    {
        OrderEntity order=orderService.save(orderDto);
        return ResponseEntity.ok(order);
    }

    @PutMapping(updateCustomerAPI)
    public ResponseEntity<OrderEntity> updateOrder(@RequestParam Long id,@RequestBody OrderDto orderDto)
    {
        OrderEntity order=orderService.updateOrder(id,orderDto);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(deleteCustomerAPI)
    public ResponseEntity<String> deleteOrder(@RequestParam Long id) {
        try {
            orderService.delete(id);
            return ResponseEntity.ok("Deleted order with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        }
    }
}
