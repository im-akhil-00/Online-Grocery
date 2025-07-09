package com.crio.onlineGrocery.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CustomerDto {
    private String name;
    private String email;
    private String address;
    private String phone;
}
