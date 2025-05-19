package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.*;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

// Empty commit to create PR
@Service
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService() {
        initTestData();
    }

    private void initTestData() {
        products.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "Ноутбук", 50000));
        products.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "Смартфон", 30000, 10));

        articles.put(UUID.randomUUID(), new Article(UUID.randomUUID(),
                "Обзор смартфонов", "Сравнение моделей 2023"));
    }

    public Collection<Product> getAllProducts() {
        return Collections.unmodifiableCollection(products.values());
    }

    public Collection<Article> getAllArticles() {
        return Collections.unmodifiableCollection(articles.values());
    }

    public Collection<Searchable> getAllSearchableItems() {
        List<Searchable> items = new ArrayList<>();
        items.addAll(products.values());
        items.addAll(articles.values());
        return items;
    }
}