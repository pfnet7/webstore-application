/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webstoreapp.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Nomysz
 */
public class Product {
    
    private Integer id;
    private UUID uuid;
    private String name;
    private BigDecimal price;
    
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        return this == object || object instanceof Product
                    && Objects.equals(uuid, ((Product) object).uuid);
    }

    @Override
    public String toString() {
        return String.format("com.webstoreapp.entity.Product[ id=%d, name=%s, price=%d", id, name, price);
    }
    
}
