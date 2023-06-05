package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore @ToString.Exclude
    private Long id;

    @ManyToOne @JsonIgnore @ToString.Exclude
    private Pedido pedido;

    @ManyToOne
    private Item item;
    private int quantidade;

    public ItemPedido(Pedido pedido, Item item, int quantidade){
        this.pedido = pedido;
        this.item = item;
        this.quantidade = quantidade;
    }

}