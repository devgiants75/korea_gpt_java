package chapter07.orderApp;

/*
* Main 클래스
* : 주문 시스템의 실행 진입점
* - 제품 생성, 주문 생성, 주문 결과 출력 등
* */
public class Main {
    public static void main(String[] args) {
        // 제품 생성
        Product laptop = new Electronics("Laptop", 5000);
        Product apple = new Food("Apple", 6000);

        // 주문 생성
        Order order1 = new Order(laptop, 1);
        Order order2 = new Order(apple, 10);

        System.out.println(order1); // Order Detail[ Laptop * Quantity: 1 >> 5750.0 ]
        System.out.println(order2); // Order Detail[ Apple * Quantity: 10 >> 60000.0 ]
    }
}
