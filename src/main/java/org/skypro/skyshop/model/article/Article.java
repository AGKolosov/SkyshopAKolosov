package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;
import java.util.UUID;
import java.util.Objects;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String text;

    public Article(UUID id, String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок статьи не может быть пустым");
        }
        this.id = id;
        this.title = title;
        this.text = text != null ? text : "";
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public UUID getId() { return id; }

    @Override
    public String getSearchTerm() {
        return title + "\n" + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equalsIgnoreCase(article.title.trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase().trim());
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}