package ru.dronix.webshop.dao;

import ru.dronix.webshop.model.News;

import java.util.List;

/**
 * Created by ADMIN on 16.02.2017.
 */
public interface NewsDao {

    List<News> listAllNews();

}
