package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne @ToString.Exclude @JsonBackReference
    Usuario usuario;

    @OneToMany(mappedBy = "pk.pedido") @JsonManagedReference
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido(Usuario usuario){
        this.usuario = usuario;
    }

}