package chapter10.practice2.entity;

public abstract class Item {
    private String id; // 고유 식별자
    private String name; // 상품명
    private int price; // 가격
    private int quantity; // 재고 수량

    public Item(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getCategory(); // 카테고리 반환

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: "
                + price + ", Quantity: " + quantity;
    }
}
