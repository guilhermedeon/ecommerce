package com.g11.ecommerce.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.g11.ecommerce.JsonService;
import com.g11.ecommerce.entities.*;
import com.g11.ecommerce.repositories.ItemPedidoRepository;
import com.g11.ecommerce.repositories.ItemRepository;
import com.g11.ecommerce.repositories.PedidoRepository;
import com.g11.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String snoparam(){
        return setup(10);
    }

    @GetMapping("/setup/{repeat}")
    public String s(@PathVariable int repeat){
        return setup(repeat);
    }

    public String setup(int repeat){
        Item item = new Item("Teste Item");
        item.setId(itemRepository.save(item).getId());
        for (int i = 0; i < repeat;i++){
            Usuario usuario = new Usuario("Teste nome", "TesteUser", "TesteSenha", Nivel.USUARIO);
            usuario.setId(usuarioRepository.save(usuario).getId());
            for (int k = 0; k < 2;k++) {
                Pedido pedido = new Pedido(usuario);
                pedido.setId(pedidoRepository.save(pedido).getId());
                for (int l = 0; l < 3;l++) {
                    ItemPedido itemPedido = new ItemPedido(pedido, item, 1);
                    itemPedidoRepository.save(itemPedido);
                }
            }
        }
        String ret = "Setup ran " + String.valueOf(repeat) + " times.";
        return ret;
    }

    @GetMapping()
    public String returns() throws JsonProcessingException {
        jsonService.toJson(usuarioRepository.findAll());
        return jsonService.toJson(usuarioRepository.findAll());
    }



}
