package ru.dronix.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dronix.webshop.dao.NewsDao;
import ru.dronix.webshop.model.News;

import java.util.List;

/**
 * Created by ADMIN on 16.02.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Transactional
    @Override
    public List<News> listAllNews() {
        return this.newsDao.listAllNews();
    }
}
