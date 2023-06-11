package com.g11.ecommerce.entities.dto;

import com.g11.ecommerce.entities.Item;

public record ItemResponseDTO(Long id, String nome, String url) {
    public ItemResponseDTO(Item item){
        this(item.getId(),item.getNome(), item.getUrlImagem());
    }
}
