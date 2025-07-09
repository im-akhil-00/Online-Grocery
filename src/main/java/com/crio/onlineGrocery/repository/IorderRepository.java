package com.crio.onlineGrocery.repository;

import com.crio.onlineGrocery.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IorderRepository extends JpaRepository<OrderEntity,Long> {
}
