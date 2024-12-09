package chapter12.model;

/*
* Book 클래스
* : 책 객체를 정의하는 클래스
*
* @Field
*   제목, 저자, 출판사
* */
public class Book {
    // 인스턴스 변수
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher;
    }
}
