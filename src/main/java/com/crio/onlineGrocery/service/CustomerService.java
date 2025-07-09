package com.crio.onlineGrocery.service;

import com.crio.onlineGrocery.dto.CustomerDto;
import com.crio.onlineGrocery.model.CustomerEntity;
import com.crio.onlineGrocery.repository.IcustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class CustomerService {
   @Autowired
   IcustomerRepository icustomerRepositoryService;
   @Autowired
   ModelMapper modelMapper;

   private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

   public CustomerEntity saveCustomer(CustomerDto customer)
   {
      CustomerEntity customerEntity =modelMapper.map(customer, CustomerEntity.class);
      log.info(customerEntity.toString());
       return icustomerRepositoryService.save(customerEntity);
   }

   public List<CustomerEntity> getCustomers()
   {
      return icustomerRepositoryService.findAll();
   }

   public CustomerEntity getCustomerById(Long id){
      return icustomerRepositoryService.findById(id)
              .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
   }

   public CustomerEntity update(Long Id, CustomerDto cDto)
   {
      CustomerEntity customerEntity = getCustomerById(Id);
      modelMapper.map(cDto, customerEntity); // modifies existing object
      return icustomerRepositoryService.save(customerEntity);
   }

   public void delete(Long id) {
      getCustomerById(id); // will throw exception if not found
      icustomerRepositoryService.deleteById(id);
   }

}
