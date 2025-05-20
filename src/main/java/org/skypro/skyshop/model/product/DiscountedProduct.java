package org.skypro.skyshop.model.product;

import java.util.UUID;

// Empty commit to create PR
public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(UUID id, String name, int basePrice, int discount) {
        super(id, name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть больше 0.");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100 включительно.");
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