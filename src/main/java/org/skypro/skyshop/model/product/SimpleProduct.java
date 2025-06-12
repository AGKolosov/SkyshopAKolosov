package org.skypro.skyshop.model.product;

import org.skypro.skyshop.exceptions.NoSuchProductException;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(UUID id, String name, int price) {
        super(id, name);
        if (price <= 0) {
            throw new NoSuchProductException("Price must be positive");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s [%d руб.]", getName(), price);
    }
}