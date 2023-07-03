package com.g11.ecommerce.controllers;


import com.g11.ecommerce.entities.Item;
import com.g11.ecommerce.repositories.ItemRepository;
import com.g11.ecommerce.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    ItemService itemService = new ItemService(itemRepository);

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable int id){
        return ResponseEntity.ok(itemRepository.findByid(id).orElseThrow());
    }

}
