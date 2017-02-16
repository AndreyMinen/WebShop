package ru.dronix.webshop.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ADMIN on 16.02.2017.
 */
@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "descr")
    private String descr;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
