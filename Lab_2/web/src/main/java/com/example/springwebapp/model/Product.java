package com.example.springwebapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String manufacturer1;
    private Integer price;
    private String color;
    private String prevImage;
    private String city;
public  Product(){

}
    public Product(final String manufacturer, final String manufacturer1, final Integer price, final String color, final String prevImage, String City,Long id) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.color = color;
        this.prevImage = prevImage;
        this.manufacturer1 = manufacturer1;
        this.city = City;
        this.id=id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer1() {
        return this.manufacturer1;
    }

    public void setManufacturer1(final String manufacturer1) {
        this.manufacturer1 = manufacturer1;
    }

    public String getPrevImage() {
        return this.prevImage;
    }

    public void setPrevImage(final String prevImage) {
        this.prevImage = prevImage;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public Integer getPrice() {

        return this.price;
    }

    public void setPrice(final Integer price) {

        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
