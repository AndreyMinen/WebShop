package ru.dronix.webshop.dao;

import ru.dronix.webshop.model.Category;

import java.util.List;

/**
 * Created by ADMIN on 19.01.2017.
 */
public interface CategoryDao {

    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> getBrandsByType(String type);
}
