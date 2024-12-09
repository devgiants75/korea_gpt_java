package chapter12.controller;

import chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    // Book 데이터를 사용하여 기능 정의
    private List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
    }

    // 1. 책을 추가하는 기능
    public void addBook(String title, String author, String publisher) {
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> searchBook(String title) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }

        return result;
    }
}
