package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.*;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProduct(UUID productId) {
        Product product = storageService.getProductById(productId)
                .orElseThrow(() -> new NoSuchProductException("Товар не найден"));

        productBasket.addProduct(productId);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProducts().entrySet().stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int quantity = entry.getValue();

                    Product product = storageService.getProductById(productId)
                            .orElseThrow(() -> new NoSuchProductException("Товар в хранилище не найден"));

                    return new BasketItem(product, quantity);
                })
                .collect(Collectors.toList());

        return new UserBasket(basketItems);
    }
}