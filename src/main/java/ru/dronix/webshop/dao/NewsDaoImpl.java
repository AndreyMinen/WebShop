package ru.dronix.webshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dronix.webshop.model.News;

import java.util.List;

/**
 * Created by ADMIN on 16.02.2017.
 */
@Repository
public class NewsDaoImpl implements NewsDao {

    private List<News> listNews;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> listAllNews() {
        Session session=this.sessionFactory.getCurrentSession();
        listNews=(List<News>)session.createCriteria(News.class).list();

        return listNews;
    }
}
