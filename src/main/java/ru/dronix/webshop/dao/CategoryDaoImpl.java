package ru.dronix.webshop.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dronix.webshop.model.Category;

import java.util.List;

/**
 * Created by ADMIN on 19.01.2017.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger log=Logger.getLogger(CategoryDaoImpl.class);

    @Override
    public void addCategory(Category category) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(category);
        log.info("Добавлена категория: "+category);
    }

    @Override
    public void updateCategory(Category category) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(category);
        log.info("Обновлена категория: "+category);
    }

    @Override
    public void deleteCategory(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Category category=getCategoryById(id);
        session.delete(category);
        log.info("Удалена категория: "+category);
    }

    @Override
    public Category getCategoryById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Category category=(Category)session.load(Category.class,new Integer(id));

        return category;
    }

    @Override
    public List<Category> getBrandsByType(String type) {
        Session session=this.sessionFactory.getCurrentSession();
        List<Category> listCategory=(List<Category>)session.createCriteria(Category.class)
                .add(Restrictions.eq("type",type)).list();
        return listCategory;
    }
}
