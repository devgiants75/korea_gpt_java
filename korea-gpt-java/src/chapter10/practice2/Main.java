package chapter10.practice2;

/*
* Inventory Management System
* : 다양한 상품을 관리하는 재고 관리 시스템
*
* 1) 프로젝트 구조
* - entity 폴더 (Item, Electronics - 전자제품, Furniture - 가구)
* - service 폴더
* - repository 폴더
*
* - Main 클래스
*
* 2) 요구 사항
* - 기능
*       상품(Item) 추가, 수정, 삭제, 카테고리별 상품 검색, 가격 또는 이름 등으로 정렬
* - 사용 컬렉션
*       Set: 상품 관리 (중복 상품 방지)
*       Map: 카테고리별 상품 분류 (Key: 카테고리명, Value: 상품 목록)
* - 추상클래스(Item): 모든 상품의 공통 필드를 포함
* - 인터페이스(Discountable): 할인 로직 제공
* */

// cf) CRUD (크루드)
// : Create, Read, Update, Delete
// - 소프트웨어 개발에서 데이터를 처리하는 기본적인 네 가지 작업

import chapter10.practice2.entity.Electronics;
import chapter10.practice2.entity.Furniture;
import chapter10.practice2.entity.Item;
import chapter10.practice2.repository.InMemoryItemRepository;
import chapter10.practice2.service.InventoryService;
import chapter10.practice2.service.InventoryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl(new InMemoryItemRepository());
        // Scanner scanner = new Scanner(System.in);

        // 상품 추가
        Item laptop1 = new Electronics("E001", "Samsung Book3 Pro", 20000, 10, "Samsung", 12);
        Item laptop2 = new Electronics("E002", "Samsung Book4", 25000, 5, "Samsung", 12);

        inventoryService.addItem(laptop1);
        inventoryService.addItem(laptop2);
        inventoryService.addItem(new Furniture("F001", "Fabric Sofa", 30000, 15, "Fabric", "4인"));
        inventoryService.addItem(new Furniture("F002", "Leather Sofa", 33000, 10, "Leather", "3인"));

        // 카테고리별 상품 검색
        List<Item> electronics = inventoryService.getItemsByCategory("Electronics");
        List<Item> furniture = inventoryService.getItemsByCategory("Furniture");

        System.out.println("All Electronics");
        for (Item item : electronics) {
            System.out.println(item);
        }

        System.out.println("All Furniture");
        for (Item item : furniture) {
            System.out.println(item);
        }

        // 상품 가격 업데이트
        inventoryService.updateItemPrice("E001", 27000);
        System.out.println("Updated price");
        for (Item item : inventoryService.getItemsByCategory("Electronics")) {
            System.out.println(item);
        }
    }
}
