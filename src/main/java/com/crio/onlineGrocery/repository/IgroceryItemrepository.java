package com.crio.onlineGrocery.repository;

import com.crio.onlineGrocery.model.GroceryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgroceryItemrepository extends JpaRepository<GroceryItemEntity,Long> {

}
