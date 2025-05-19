package org.skypro.skyshop.model.search;

import java.util.UUID;

// Empty commit to create PR
public interface Searchable {
    UUID getId();

    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getSearchTerm() + " — " + getContentType();
    }
}