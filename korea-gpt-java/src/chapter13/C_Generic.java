package chapter13;

// 제네릭 와일드카드 정리 //
// 1. 일반 와일드카드 (?)
// : 모든 타입 허용
// : List<?>

// 2. 상한 제한 와일드카드 (? extends Type)
// : 특정 타입 및 그 하위 클래스만 허용
// : List<? extends Number>

// 3. 하한 제한 와일드카드 (? super Type)
// : 특정 타입 및 그 상위 클래스만 허용
// : List<? super Integer>

// == 주문 관리 시스템 == //
// 상품(Product)과 할인(Discount) 정보를 관리
// : 할인 정책을 적용할 때,
//      할인은 Product 또는 Product를 상속받는 하위 클래스에서만 적용

import java.util.ArrayList;
import java.util.List;

// 1. 상위 클래스: Product
class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price =  price;
    }

    public int getPrice() { return price; }
    public String getName() { return name; }
}

// 하위 클래스: Electronics
class Electronics extends Product {
    public Electronics(String name, int price) {
        super(name, price);
    }
}

// 하위 클래스: Furniture
class Furniture extends Product {
    public Furniture(String name, int price) {
        super(name, price);
    }
}

class DiscountPolicy {
    public static double applyDiscount(List<? extends Product> products, double discountRate) {
        double totalDiscount = 0.0;

        for (Product product : products) {
            double discount = product.getPrice() * discountRate;
            totalDiscount += discount;
            System.out.println(product.getName() + " 할인 적용: " + discount + "원");
        }

        return totalDiscount;
    }
}

public class C_Generic {
    public static void main(String[] args) {
        List<Electronics> electronics = new ArrayList<>();
        electronics.add(new Electronics("냉장고", 257));
        electronics.add(new Electronics("세탁기", 130));
        electronics.add(new Electronics("인덕션", 106));

        double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);

        List<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture("침대", 230));
        furnitureList.add(new Furniture("쇼파", 260));
        furnitureList.add(new Furniture("화장대", 80));

        double totalFurnitureList = DiscountPolicy.applyDiscount(furnitureList, 0.2);

        System.out.println("총 가전 할인액: " + totalElectronics + "원");
        System.out.println("총 가구 할인액: " + totalFurnitureList + "원");

        List<Product> products = new ArrayList<>();
    }
}
