package com.g11.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private boolean isOpen = true;

    @ManyToOne @ToString.Exclude @JsonBackReference
    Usuario usuario;

    @OneToMany(mappedBy = "pk.pedido") @JsonManagedReference
    private List<ItemPedido> itensPedido = new ArrayList<>();


    public Pedido(Usuario usuario){
        this.usuario = usuario;
    }

    public void close(){
        this.isOpen = false;
    }

}