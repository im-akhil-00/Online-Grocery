package com.crio.onlineGrocery.dto;

import com.crio.onlineGrocery.model.CustomerEntity;
import com.crio.onlineGrocery.model.GroceryItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@JsonIgnoreProperties
public class OrderDto {
    private int id;
    private CustomerEntity customer;
    private List<GroceryItemEntity> groceryItemEntities;
    private LocalDate orderDate;
    private int totalPrice;
}
