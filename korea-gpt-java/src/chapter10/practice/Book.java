package chapter10.practice;

public class Book extends Item {
    private String isbn;
    private String author;
    private String publisher;
    private int publishYear;
    private int price;
    private int stock;
    private String category;

    public Book(String id, String name, String isbn, String author, String publisher, int publishYear, int price, int stock, String category) {

        // cf) 추상 클래스의 인스턴스화
        //      : 추상 클래스는 인스턴스화 될 수 X
        //      - 직접적으로 객체 생성이 불가
        // +) 추상 클래스 내에 생성자 정의는 가능하며 하위 클래스의 생성자를 통해 호출
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getPublishYear() { return publishYear; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    public String getCategory() { return category; }

    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", ISBN: " + isbn);
    }
}
