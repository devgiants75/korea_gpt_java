package chapter10.practice2.service;

import chapter10.practice2.entity.Item;
import chapter10.practice2.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InventoryServiceImpl implements InventoryService {
    private ItemRepository repository;

    public InventoryServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addItem(Item item) {
        repository.addItem(item);
    }

    @Override
    public void updateItemPrice(String itemId, int newPrice) {
        Item item = repository.findById(itemId);

        if (item != null) {
            item.setPrice(newPrice);
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Item item = repository.findById(itemId);

        if (item != null) {
            repository.removeItem(itemId);
        }
    }

    @Override
    public List<Item> getItemsByCategory(String category) {
        Set<Item> allItems = repository.findAll();
        List<Item> categoryItems = new ArrayList<>();

        for (Item item : allItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                categoryItems.add(item);
            }
        }
        return categoryItems;
    }
}
