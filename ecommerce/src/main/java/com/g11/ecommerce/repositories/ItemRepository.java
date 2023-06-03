package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}