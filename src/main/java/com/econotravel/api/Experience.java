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
    private String descripcion;

    private double price;
    private int time;
    private String category;

    @Lob
    private String imgUrl;

    public Experience() {
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


    public Experience(String name, String descripcion, double price, int time, String category, String imgUrl) {
        this.name = name;
        this.descripcion = descripcion;
        this.price = price;
        this.time = time;
        this.category = category;
        this.imgUrl = imgUrl;
    }



    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", category='" + category + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience experience = (Experience) o;
        return Double.compare(experience.price, price) == 0 && Objects.equals(id, experience.id) && Objects.equals(name, experience.name) && Objects.equals(descripcion, experience.descripcion) && Objects.equals(category, experience.category) && Objects.equals(time, experience.time) && Objects.equals(imgUrl, experience.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descripcion, category, time, price, imgUrl);
    }



}




