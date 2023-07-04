package com.g11.ecommerce.controllers;


import com.g11.ecommerce.entities.Item;
import com.g11.ecommerce.repositories.ItemRepository;
import io.swagger.v3.core.util.Json;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id){
        return ResponseEntity.ok(itemRepository.findByid(id).orElseThrow());
    }

    @PostMapping()
    public ResponseEntity<Item> postItem(@RequestBody Item item){
        return ResponseEntity.ok(itemRepository.save(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable int id){
        itemRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping()
        public ResponseEntity deleteAll(){
            itemRepository.deleteAll();
            return ResponseEntity.accepted().build();
        }


    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, Item item){
        Item oldItem = itemRepository.findByid(id).orElseThrow();
        oldItem.setNome(item.getNome());
        oldItem.setUrlImagem(item.getUrlImagem());
        return ResponseEntity.ok(itemRepository.save(oldItem));
    }
}
