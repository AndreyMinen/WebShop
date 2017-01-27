package ru.dronix.webshop.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dronix.webshop.model.Product;

import java.util.List;

/**
 * Created by ADMIN on 16.01.2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger log=Logger.getLogger(ProductDaoImpl.class);

    private List<Product> listProducts;

    public void addProduct(Product product) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(product);
        log.info("Добавлен продукт: "+product);
    }

    public void updateProduct(Product product) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(product);
        log.info("Продукт обновлен на "+product);
    }

    public void deleteProduct(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Product product=getProductById(id);
        session.delete(product);
        log.info("Удален продукт: "+product);
    }

    public Product getProductById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Product product=(Product)session.load(Product.class,new Integer(id));
        log.info("Загружен продукт: "+product);
        return product;
    }

    public List<Product> getAllProducts() {
        Session session=this.sessionFactory.getCurrentSession();
        listProducts=session.createCriteria(Product.class).add(Restrictions.eq("visible",1)).list();
        log.info("Получен список всех продуктов");
        return listProducts;
    }

    public List<Product> getProductsAscPrice() {
        Session session=this.sessionFactory.getCurrentSession();
        listProducts=session.createCriteria(Product.class).add(Restrictions.eq("visible", 1))
                .addOrder(Order.asc("price")).list();
        log.info("Получен отсортированный asc по цене список всех продуктов");
        return listProducts;
    }

    public List<Product> getProductsDescPrice() {
        Session session=this.sessionFactory.getCurrentSession();
        listProducts=session.createCriteria(Product.class).add(Restrictions.eq("visible", 1))
                .addOrder(Order.desc("price")).list();
        log.info("Получен отсортированный desc по цене список всех продуктов");
        return listProducts;
    }

    public List<Product> getProductsPopular() {
        return null;
    }

    public List<Product> getProductsNew() {
        return null;
    }

    public List<Product> getProductsAsc() {
        Session session=this.sessionFactory.getCurrentSession();
        listProducts=session.createCriteria(Product.class).add(Restrictions.eq("visible", 1))
                .addOrder(Order.asc("title")).list();
        log.info("Получен отсортированный по названию список всех продуктов");
        return listProducts;
    }

    @Override
    public List<Product> getProductsByBrandByType(String brand, String type) {
        Session session=this.sessionFactory.getCurrentSession();
        listProducts=session.createCriteria(Product.class)
                .add(Restrictions.eq("type_product",type))
                .add(Restrictions.eq("brand",brand))
                .add(Restrictions.eq("visible",1))
                .list();
        log.info("Получен список товаров по типу и бренду. Товаров: "+listProducts.size());

        return listProducts;
    }


}
