package com.g11.ecommerce.services;

import com.g11.ecommerce.entities.Item;
import com.g11.ecommerce.entities.dto.ItemCreateDTO;
import com.g11.ecommerce.entities.dto.ItemResponseDTO;
import com.g11.ecommerce.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public ResponseEntity<ItemResponseDTO> create(Item item){
        if (!checkExistingByName(item)){
            itemRepository.save(item);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.badRequest().build();
    }
    public ResponseEntity<ItemResponseDTO> create(ItemCreateDTO dto){
       return create(new Item(dto));
    }

    public ResponseEntity deleteById(Long id){
        itemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    public boolean checkExistingByName(String name){
        boolean ret = false;
        List<Item> itens = itemRepository.findAll();
        for (Item i : itens){
            if (i.getNome().contains(name)) ret = true;
        }
        return ret;
    }
    public boolean checkExistingByName(ItemCreateDTO dto){
        return checkExistingByName(dto.nome());
    }
    public boolean checkExistingByName(Item item){
        return checkExistingByName(item.getNome());
    }

    public Optional<ItemResponseDTO> findByName(String name){
        List<Item> items = itemRepository.findAll();
        ItemResponseDTO response = null;
        for (Item i : items){
            if (i.getNome().contains(name)) response = new ItemResponseDTO(i);
        }
        return Optional.of(response);
    }
    public Optional<ItemResponseDTO> findByName(ItemResponseDTO dto){
        return findByName(dto.nome());
    }
    public Optional<ItemResponseDTO> findByName(Item item){
        return findByName(item.getNome());
    }

}
