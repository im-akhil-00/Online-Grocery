package com.crio.onlineGrocery.controller;

import com.crio.onlineGrocery.dto.CustomerDto;
import com.crio.onlineGrocery.model.CustomerEntity;
import com.crio.onlineGrocery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    public static final String CustomersAPI="/getCustomers";
    public static final String SaveCustomerAPI="/saveCustomer";
    public static final String UpdateCustomerAPI="/updateCustomer";
    public static final String DeleteCustomerAPI="/deleteCustomer";


    @Autowired
    CustomerService customerService;

    @GetMapping(CustomersAPI)
    public ResponseEntity<List<CustomerEntity>> getCustomers()
    {
        List<CustomerEntity> customerEntities=customerService.getCustomers();
        return ResponseEntity.ok().body(customerEntities);
    }

    @PostMapping(SaveCustomerAPI)
    public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerDto customerDto)
    {
        CustomerEntity customer=customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(customer);
    }

    @PutMapping(UpdateCustomerAPI)
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestParam Long id,@RequestBody CustomerDto customerDto)
    {
        CustomerEntity customer=customerService.update(id,customerDto);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping(DeleteCustomerAPI)
    public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.ok("Deleted customer with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        }
    }

}
