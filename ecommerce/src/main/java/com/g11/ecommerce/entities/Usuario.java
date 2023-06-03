package com.g11.ecommerce.entities;

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

    @OneToMany (mappedBy = "usuario")
    List<Pedido> pedidos = new ArrayList<>();

}