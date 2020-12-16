package com.example.springwebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class checkEdUser {
    public Long getId_chek() {
        return id_chek;
    }

    public void setId_chek(Long id_chek) {
        this.id_chek = id_chek;
    }

    public String getCity_user() {
        return city_user;
    }

    public void setCity_user(String city_user) {
        this.city_user = city_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public checkEdUser(String city_user, Date date) {
        this.id_chek = id_chek;
        this.city_user = city_user;
        this.date = date;
    }

    public checkEdUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_chek;
    private String city_user;
    private Date date;
}
