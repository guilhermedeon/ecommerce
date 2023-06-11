package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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