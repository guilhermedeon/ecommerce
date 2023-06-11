package com.g11.ecommerce;

import com.g11.ecommerce.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    public void assertCreation(){
        Item item = new Item("Caixa","url");
        assertThat(item.getNome().contains("Caixa"));
    }
}
