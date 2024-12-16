package chapter16.practice.entity;

import lombok.Getter;

@Getter
public class Book extends Item {
    private String isbn;
    private String author;
    private String publisher;
    private int publishYear;
    private int price;
    private int stock;
    private Category category;

    public Book(String id, String name, String isbn, String author, String publisher
        , int publishYear, int price, int stock, Category category
    ) {
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId()
                + ", Title: " + getName()
                + ", Category: " + getCategory());
    };
}