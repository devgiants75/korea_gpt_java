package chapter13.practice.repository;

import chapter13.practice.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>(); // 데이터베이스

    public void save(Book book) {
        books.add(book);
    }

    public void deleteById(int id) {
        Book bookToRemove = null;

        for (Book book : books) {
            if (book.getId() == id) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return books;
    }
}
