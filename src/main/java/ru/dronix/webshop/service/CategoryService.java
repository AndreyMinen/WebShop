package ru.dronix.webshop.service;

import ru.dronix.webshop.model.Category;

import java.util.List;

/**
 * Created by ADMIN on 19.01.2017.
 */
public interface CategoryService {

    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> getBrandsByType(String type);

}
