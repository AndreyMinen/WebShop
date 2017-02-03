package ru.dronix.webshop.dao;

import ru.dronix.webshop.model.Product;

import java.util.List;

/**
 * Created by ADMIN on 16.01.2017.
 */
public interface ProductDao {

    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsAscPrice();
    List<Product> getProductsDescPrice();
    List<Product> getProductsPopular();
    List<Product> getProductsNew();
    List<Product> getProductsAsc();
    List<Product> getProductsByType(String type);
    List<Product> getProductsByTypeSort(String type,String sort);
    List<Product> getProductsByBrandByType(String brand,String type);
    List<Product> getProductsByBrandByTypeSort(String type,String brand,String sort);
}
