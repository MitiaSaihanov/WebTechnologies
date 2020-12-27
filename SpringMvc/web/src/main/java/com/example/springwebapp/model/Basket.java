package com.example.springwebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Basket {
    public Long getId_Basket() {
        return id_Basket;
    }

    public void setId_Basket(Long id_Basket) {
        this.id_Basket = id_Basket;
    }

    public Long getId_Product() {
        return id_Product;
    }

    public void setId_Product(Long id_Product) {
        this.id_Product = id_Product;
    }

    public Long getId_Chek() {
        return id_Chek;
    }

    public void setId_Chek(Long id_Chek) {
        this.id_Chek = id_Chek;
    }

    public Basket(Long id_Chek, Long id_Product) {
        this.id_Basket = id_Basket;
        this.id_Product = id_Product;
        this.id_Chek = id_Chek;
    }

    public Basket() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Basket;
    private Long id_Product;
    private  Long id_Chek;
}
