package chapter13.practice.model;

public class Fiction extends Book {
    private String genre;

    public Fiction(int id, String title, String author, String genre) {
        super(id, title, author); // 추상 클래스 Book의 인스턴스
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}
