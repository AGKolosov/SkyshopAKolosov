package org.skypro.skyshop.model.product;
import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;  // Фиксированная цена

    // Конструктор
    public FixPriceProduct(UUID id, String name) {
        super(id, name);
    }

    // Переопределение метода getPrice
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    // Переопределение метода isSpecial
    @Override
    public boolean isSpecial() {
        return true;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
