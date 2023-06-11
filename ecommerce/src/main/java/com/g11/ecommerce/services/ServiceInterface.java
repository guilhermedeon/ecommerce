package com.g11.ecommerce.services;

import org.springframework.http.ResponseEntity;

public interface ServiceInterface {
    public void getAll();
    public <T> T findById();

    public ResponseEntity create();

    public ResponseEntity update();


}
