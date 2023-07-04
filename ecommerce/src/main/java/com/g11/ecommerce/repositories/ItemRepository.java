package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    public Optional<Item>  findByid(int id);
    public Optional<Item> findByNome(String nome);

    public void deleteAll();
}