package com.g11.ecommerce.services;

import com.g11.ecommerce.entities.Pedido;
import com.g11.ecommerce.entities.Usuario;
import com.g11.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getPedidos(Usuario usuario){
        return pedidoRepository.findAllByUsuario_Id(usuario.getId());
    }

    public void savePedido(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public void deletePedido(int id){
        pedidoRepository.deleteById(id);
    }
}
