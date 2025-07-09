package com.crio.onlineGrocery.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class GroceryItemDto {
    private int id;
    private String name;
    private String category;
    private int price;
    private int quantity;
}
