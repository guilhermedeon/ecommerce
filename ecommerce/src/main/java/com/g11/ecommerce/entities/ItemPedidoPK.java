package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoPK implements Serializable {

    @ManyToOne @JsonBackReference @ToString.Exclude
    private Pedido pedido;

    @ManyToOne
    private Item item;

}
