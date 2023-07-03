package com.g11.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "item_pedido")

public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK pk;

    private int quantidade;

    public ItemPedido(Pedido pedido, Item item, int quantidade){
        this.quantidade = quantidade;
        this.pk = new ItemPedidoPK(pedido,item);
    }

}