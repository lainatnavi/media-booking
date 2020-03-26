package com.mbooking.model;

public abstract class Media {
    protected long id;
    protected String name;
    protected String author;

    protected Media(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
