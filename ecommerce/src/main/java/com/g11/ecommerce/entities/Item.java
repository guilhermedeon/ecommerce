package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String urlImagem;

    @ToString.Exclude
    @OneToMany(mappedBy = "item") @JsonIgnore
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Item(String nome){
        this.nome = nome;
    }

}