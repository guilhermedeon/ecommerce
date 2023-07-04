package com.g11.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private String nome;
    private String urlImagem;

    public Item(String nome){
        this.nome = nome;
    }

    public Item(String nome, String urlImagem){
        this.nome = nome;
        this.urlImagem = urlImagem;
    }

}