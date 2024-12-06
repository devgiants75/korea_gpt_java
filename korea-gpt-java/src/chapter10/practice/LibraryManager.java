package chapter10.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryManager implements Manageable {
    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    @Override
    public void remove(String id) {
        boolean removed = false; // 삭제 여부 확인용 데이터

        int size = items.size();
        for (int i = 0; i < size; i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");
                break;
            }
        }

        if (!removed) {
            System.out.println("No item found with ID: " + id);
        }
    }

    @Override
    public List<Item> search(String keyword) {
        List<Item> foundItems = new ArrayList<>();

        for (Item item : items) {
            if (item.getName().contains(keyword)
                || (item instanceof Book && ((Book)item).getAuthor().contains(keyword) || ((Book)item).getPublisher().contains(keyword) )
            ) {
                foundItems.add(item);
            }
        }

        if (foundItems.isEmpty()) {
            // 배열.isEmpty(): 비워진 경우 true 반환
            throw new NoSuchElementException("No item found for keyword: " + keyword);
        }
        return foundItems;
    }

    @Override
    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Book && ((Book) item).getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Book) {
                int price = ((Book) item).getPrice();
                if (price >= minPrice && price <= maxPrice) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    @Override
    public void updateStock(String id, int quantity) {
        for (Item item : items) {
            if (item.getId().equals(id) && item instanceof Book) {
                ((Book) item).updateStock(quantity);
                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book) item).getStock());
                return;
            }
        }
        System.out.println("No item found with ID: " + id);
    }

    @Override
    public void listAll() {
        if (items.isEmpty()) {
            System.out.println("No items in the library");
        } else {
            System.out.println("=== Library Items ===");
            for (Item item : items) {
                item.display();
            }
        }
    }
}
