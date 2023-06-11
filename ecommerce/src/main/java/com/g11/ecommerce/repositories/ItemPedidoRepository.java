package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.ItemPedido;
import com.g11.ecommerce.entities.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}