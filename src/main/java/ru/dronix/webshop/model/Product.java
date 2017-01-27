package ru.dronix.webshop.model;

import javax.persistence.*;

/**
 * Created by ADMIN on 16.01.2017.
 */
@Entity
@Table(name = "table_products")
public class Product {

    @Id
    @Column(name = "products_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Integer price;

    @Column(name = "image")
    private String image;

    @Column(name = "mini_features")
    private String mini_descr;

    @Column(name = "visible")
    private Integer visible;

    @Column(name = "type_product")
    private String type_product;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMini_descr() {
        return mini_descr;
    }

    public void setMini_descr(String mini_descr) {
        this.mini_descr = mini_descr;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", mini_descr='" + mini_descr + '\'' +
                ", visible=" + visible +
                ", type_product='" + type_product + '\'' +
                '}';
    }
}
