package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne @JsonIgnore @ToString.Exclude
    Usuario usuario;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> listaItensPedido = new ArrayList<>();

    public Pedido(Usuario usuario){
        this.usuario = usuario;
    }

}