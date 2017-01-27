package ru.dronix.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.webshop.dao.CategoryDao;
import ru.dronix.webshop.model.Category;

import java.util.List;

/**
 * Created by ADMIN on 19.01.2017.
 */
@Service
 class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public void addCategory(Category category) {
        this.categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        this.categoryDao.updateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        this.categoryDao.deleteCategory(id);
    }

    @Override
    @Transactional
    public Category getCategoryById(int id) {
        return this.categoryDao.getCategoryById(id);
    }

    @Override
    @Transactional
    public List<Category> getBrandsByType(String type) {
        return this.categoryDao.getBrandsByType(type);
    }
}
