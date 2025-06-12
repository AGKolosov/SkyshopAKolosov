package org.skypro.skyshop.model.product;

import org.skypro.skyshop.exceptions.NoSuchProductException;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(UUID id, String name, int basePrice, int discount) {
        super(id, name);
        if (basePrice <= 0) {
            throw new NoSuchProductException("Базовая цена продукта должна быть больше 0.");
        }
        if (discount < 0 || discount > 100) {
            throw new NoSuchProductException("Скидка должна быть в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}