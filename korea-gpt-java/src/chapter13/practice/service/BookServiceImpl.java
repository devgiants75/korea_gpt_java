package chapter13.practice.service;

import chapter13.practice.model.Book;
import chapter13.practice.repository.BookRepository;

import java.util.List;

// 비즈니스 로직을 처리 - 싱글톤 패턴으로 구현
public class BookServiceImpl implements BookManager<Book> {
    private static BookServiceImpl instance;
    private final BookRepository repository = new BookRepository();

    private BookServiceImpl() {}

    public static BookServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookServiceImpl();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        repository.save(book);
        System.out.println(book.getTitle() + "(이)가 추가되었습니다.");
    }

    @Override
    public List<Book> listAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book findBookById(int id) {
        return repository.findById(id);
    }

    @Override
    public void updateBook(int id, Book updatedBook) {
        Book existingBook = repository.findById(id);
        if (existingBook != null) {
            repository.deleteById(id); // 기존 도서 삭제
            repository.save(updatedBook); // 업데이트 된 도서 추가
            System.out.println("ID " + id + " 도서가 업데이트 되었습니다.");
        } else {
            System.out.println("ID " + id + "에 해당하는 책이 없습니다.");
        }
    }

    @Override
    public void removeBook(int id) {
        Book existingBook = repository.findById(id);
        if (existingBook != null) {
            repository.deleteById(id);
            System.out.println(existingBook.getTitle() + "이(가) 삭제되었습니다.");
        } else {
            System.out.println("ID " + id +  "에 해당하는 책이 없습니다.");
        }
    }
}
