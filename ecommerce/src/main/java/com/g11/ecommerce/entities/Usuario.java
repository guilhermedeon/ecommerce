package com.g11.ecommerce.entities;

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
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String username;
    private String senha;
    @Enumerated
    private Nivel nivel;

    @OneToMany (mappedBy = "usuario") @JsonManagedReference
    List<Pedido> pedidos = new ArrayList<>();

    public Usuario(String nome, String username, String senha, Nivel nivel){
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.nivel = nivel;
    }

}