package com.crio.onlineGrocery.repository;

import com.crio.onlineGrocery.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
