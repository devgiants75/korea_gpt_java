package chapter16.practice.service;

import chapter16.practice.entity.Category;
import chapter16.practice.entity.Item;

import java.util.List;

public interface Manageable {
    List<Item> searchByCategory(Category category);
}