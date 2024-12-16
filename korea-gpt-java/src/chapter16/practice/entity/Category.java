package chapter16.practice.entity;

public enum Category {
    FICTION,
    NONFICTION,
    SCIENCE,
    HISTORY,
    FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + value);
        }
    }
}
