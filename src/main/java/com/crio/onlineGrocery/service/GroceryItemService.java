package com.crio.onlineGrocery.service;

import com.crio.onlineGrocery.dto.GroceryItemDto;
import com.crio.onlineGrocery.model.GroceryItemEntity;
import com.crio.onlineGrocery.repository.IgroceryItemrepository;
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
public class GroceryItemService {
    @Autowired
    IgroceryItemrepository igroceryItemrepositoryService;
    @Autowired
    ModelMapper modelMapper;
    public GroceryItemEntity save(GroceryItemDto groceryItemDto)
    {
        GroceryItemEntity groceryItemEntity= modelMapper.map(groceryItemDto,GroceryItemEntity.class);
        return igroceryItemrepositoryService.save(groceryItemEntity);
    }
    public List<GroceryItemEntity> getItems()
    {
        return igroceryItemrepositoryService.findAll();
    }
    public GroceryItemEntity getByItemId(Long Id)
    {
        return igroceryItemrepositoryService.findById(Id).orElseThrow(()->new RuntimeException("groceryItem not found with Id "+Id));
    }
    public GroceryItemEntity updateItem(Long Id,GroceryItemDto itemDto)
    {
        GroceryItemEntity groceryItemEntity=getByItemId(Id);
        modelMapper.map(itemDto,groceryItemEntity);
        return groceryItemEntity;
    }
    public void delete(Long Id)
    {
        igroceryItemrepositoryService.deleteById(Id);
    }
}
