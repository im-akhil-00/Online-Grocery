package com.crio.onlineGrocery.controller;


import com.crio.onlineGrocery.dto.GroceryItemDto;
import com.crio.onlineGrocery.model.GroceryItemEntity;
import com.crio.onlineGrocery.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroceryItemsController {
    private static final String itemsAPI="/getItems";
    private static final String saveItemsAPI="/saveItems";
    private static final String updateItemAPI="/updateItems";
    private static final String deleteItemAPI="/deleteItem";
    @Autowired
    GroceryItemService groceryItemService;

    @GetMapping(itemsAPI)
    public ResponseEntity<List<GroceryItemEntity>> getCustomers()
    {
        List<GroceryItemEntity> groceryItemEntities=groceryItemService.getItems();
        return ResponseEntity.ok().body(groceryItemEntities);
    }

    @PostMapping(saveItemsAPI)
    public ResponseEntity<GroceryItemEntity> saveItems(@RequestBody GroceryItemDto itemDto)
    {
        GroceryItemEntity item=groceryItemService.save(itemDto);
        return ResponseEntity.ok(item);
    }

    @PutMapping(updateItemAPI)
    public ResponseEntity<GroceryItemEntity> updateCustomer(@RequestParam Long id,@RequestBody GroceryItemDto itemDto)
    {
        GroceryItemEntity item=groceryItemService.updateItem(id,itemDto);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping(deleteItemAPI)
    public ResponseEntity<String> deleteItem(@RequestParam Long id) {
        try {
            groceryItemService.delete(id);
            return ResponseEntity.ok("Deleted item with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        }
    }


}
