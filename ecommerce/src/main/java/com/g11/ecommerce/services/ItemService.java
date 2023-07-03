package com.g11.ecommerce.services;

import com.g11.ecommerce.entities.Item;
import com.g11.ecommerce.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> findItemById(int id){
        return itemRepository.findByid(id);
    }

    public Optional<Item> findItemByNome(String name){
        return itemRepository.findByNome(name);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public void updateItem(int id, Item newItem) {
        if (itemRepository.findByid(id).isPresent()) {
            Item oldItem = itemRepository.findByid(id).get();
            oldItem.setNome(newItem.getNome());
            oldItem.setUrlImagem(newItem.getUrlImagem());
            itemRepository.save(oldItem);
        }
    }

    public void deleteItem(int id){
        itemRepository.deleteById(id);
    }


}
