package com.g11.ecommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.g11.ecommerce.entities.*;
import com.g11.ecommerce.repositories.ItemPedidoRepository;
import com.g11.ecommerce.repositories.ItemRepository;
import com.g11.ecommerce.repositories.PedidoRepository;
import com.g11.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemPedidoRepository itemPedidoRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JsonService jsonService;

    @GetMapping("/setup/")
    public String setup(){
        for (int i = 0; i < 2;i++){
        Usuario usuario = new Usuario("Teste nome", "TesteUser", "TesteSenha", Nivel.USUARIO);
        usuario.setId(usuarioRepository.save(usuario).getId());

        Item item = new Item("Teste Item");
        item.setId(itemRepository.save(item).getId());

        for (int k = 0; k < 2;k++) {
            Pedido pedido = new Pedido(usuario);
            pedido.setId(pedidoRepository.save(pedido).getId());
            for (int l = 0; l < 2;l++) {

                ItemPedido itemPedido = new ItemPedido(pedido, item, 1);
                itemPedidoRepository.save(itemPedido);
            }
        }
    }
        return "Setup";
    }

    @GetMapping()
    public String returns() throws JsonProcessingException {
        jsonService.toJson(usuarioRepository.findAll());
        return jsonService.toJson(usuarioRepository.findAll());
    }



}
