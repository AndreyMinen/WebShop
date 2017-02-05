package ru.dronix.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.webshop.dao.ProductDao;
import ru.dronix.webshop.model.Product;

import java.util.List;

/**
 * Created by ADMIN on 16.01.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Transactional
    public void deleteProduct(int id) {
        this.productDao.deleteProduct(id);
    }

    @Transactional
    public Product getProductById(int id) {
        return this.productDao.getProductById(id);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return this.productDao.getAllProducts();
    }

    @Transactional
    public List<Product> createSQLQuery(String query) {
        return this.productDao.createSQLQuery(query);
    }

    @Transactional
    public List<Product> getProductsAscPrice() {
        return this.productDao.getProductsAscPrice();
    }

    @Transactional
    public List<Product> getProductsDescPrice() {
        return this.productDao.getProductsDescPrice();
    }

    @Transactional
    public List<Product> getProductsPopular() {
        return this.productDao.getProductsPopular();
    }

    @Transactional
    public List<Product> getProductsNew() {
        return this.productDao.getProductsNew();
    }

    @Transactional
    public List<Product> getProductsAsc() {
        return this.productDao.getProductsAsc();
    }

    @Transactional
    public List<Product> getProductsByType(String type) {
        return this.productDao.getProductsByType(type);
    }

    @Transactional
    public List<Product> getProductsByTypeSort(String type, String sort) {
        return this.productDao.getProductsByTypeSort(type,sort);
    }

    @Transactional
    public List<Product> getProductsByBrandByType(String brand, String type) {
        return this.productDao.getProductsByBrandByType(brand, type);
    }

    @Transactional
    public List<Product> getProductsByBrandByTypeSort(String type, String brand, String sort) {
        return this.productDao.getProductsByBrandByTypeSort(type,brand,sort);
    }
}
