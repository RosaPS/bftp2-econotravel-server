package com.econotravel.api;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="experiences")
public class Experience implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @Lob
    private String descripcionCorta;

    @Lob
    private String descripcion;

    private double price;
    private int time;
    private String category;

    @Lob
    private String imgUrl;

    public Experience() {
    }

    public Experience( String name, String descripcionCorta, String descripcion, double price, int time, String category, String imgUrl) {

        this.name = name;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.price = price;
        this.time = time;
        this.category = category;
        this.imgUrl = imgUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcion = descripcionCorta;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descripcionCorta='" + descripcionCorta + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", category='" + category + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }





}




