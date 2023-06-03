package com.g11.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String urlImagem;

    @OneToMany(mappedBy = "item")
    private List<ItemPedido> itensPedido = new ArrayList<>();

}