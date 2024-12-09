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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl(new InMemoryItemRepository());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("=== Inventory Management System ===");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Price");
            System.out.println("3. Delete Item");
            System.out.println("4. View Items by Category");
            System.out.println("5. View All Items");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem(inventoryService, scanner);
                    break;
                case 2:
                    updateItemPrice(inventoryService, scanner);
                    break;
                case 3:
                    deleteItem(inventoryService, scanner);
                    break;
                case 4:
                    viewItemsByCategory(inventoryService, scanner);
                    break;
                case 5:
                    viewAllItems(inventoryService);
                    break;
                case 6:
                    System.out.println(" === Exiting === ");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // 상품 추가
//        Item laptop1 = new Electronics("E001", "Samsung Book3 Pro", 20000, 10, "Samsung", 12);
//        Item laptop2 = new Electronics("E002", "Samsung Book4", 25000, 5, "Samsung", 12);
//
//        inventoryService.addItem(laptop1);
//        inventoryService.addItem(laptop2);
//        inventoryService.addItem(new Furniture("F001", "Fabric Sofa", 30000, 15, "Fabric", "4인"));
//        inventoryService.addItem(new Furniture("F002", "Leather Sofa", 33000, 10, "Leather", "3인"));

        // 카테고리별 상품 검색
//        List<Item> electronics = inventoryService.getItemsByCategory("Electronics");
//        List<Item> furniture = inventoryService.getItemsByCategory("Furniture");
//
//        System.out.println("All Electronics");
//        for (Item item : electronics) {
//            System.out.println(item);
//        }
//
//        System.out.println("All Furniture");
//        for (Item item : furniture) {
//            System.out.println(item);
//        }

        // 상품 가격 업데이트
//        inventoryService.updateItemPrice("E001", 27000);
//        System.out.println("Updated price");
//        for (Item item : inventoryService.getItemsByCategory("Electronics")) {
//            System.out.println(item);
//        }
    }

    private static void addItem(InventoryService inventoryService, Scanner scanner) {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Item Price: ");
        int price = scanner.nextInt();
        System.out.print("Enter Item Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // 버퍼 소비: Consume newline
        System.out.print("Enter Item Category (Electronics/Furniture): ");
        String category = scanner.nextLine();

        if (category.equalsIgnoreCase("Electronics")) {
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter Warranty (months): ");
            int warranty = scanner.nextInt();
            scanner.nextLine();
            Item electronics = new Electronics(id, name, price, quantity, brand, warranty);
            inventoryService.addItem(electronics);
        } else if (category.equalsIgnoreCase("Furniture")) {
            System.out.print("Enter Material: ");
            String material = scanner.nextLine();
            System.out.print("Enter Size: ");
            String size = scanner.nextLine();
            Item furniture = new Furniture(id, name, price, quantity, material, size);
            inventoryService.addItem(furniture);
        } else {
            System.out.println("Invalid category. Item not added.");
        }
    }

    private static void updateItemPrice(InventoryService inventoryService, Scanner scanner) {
        System.out.print("Enter Item ID to Update Price: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Price: ");
        int newPrice = scanner.nextInt();
        scanner.nextLine();
        inventoryService.updateItemPrice(id, newPrice);
        System.out.println("Item price updated successfully.");
    }

    private static void deleteItem(InventoryService inventoryService, Scanner scanner) {
        System.out.print("Enter Item ID to Delete: ");
        String id = scanner.nextLine();
        inventoryService.deleteItem(id);
        System.out.println("Item deleted successfully.");
    }

    private static void viewItemsByCategory(InventoryService inventoryService, Scanner scanner) {
        System.out.print("Enter Category to View (Electronics/Furniture): ");
        String category = scanner.nextLine();
        List<Item> items = inventoryService.getItemsByCategory(category);
        if (items.isEmpty()) {
            System.out.println("No items found in this category.");
        } else {
            System.out.println("Items in category " + category + ":");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private static void viewAllItems(InventoryService inventoryService) {
        List<Item> allItems = new ArrayList<>(inventoryService.getItemsByCategory("Electronics"));
        allItems.addAll(inventoryService.getItemsByCategory("Furniture"));

        if (allItems.isEmpty()) {
            System.out.println("No items available.");
        } else {
            System.out.println("All Items:");
            for (Item item : allItems) {
                System.out.println(item);
            }
        }
    }
}
