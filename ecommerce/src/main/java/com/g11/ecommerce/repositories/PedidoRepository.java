package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}