package com.g11.ecommerce.repositories;

import com.g11.ecommerce.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    public Optional<Pedido> findById(int id);

    public List<Pedido> findAllByUsuario_Id(int id);
}