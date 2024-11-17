package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String description;
    private Double price;
    private String imageUrl;

    public Product(){
        id = 0L;
        name = null;
        category = null;
        description = null;
        price = 0.0D;
        imageUrl = null;

    }

    public Product(Long id, String name, String category, String description, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Product)){
            return false;
        }
        if(this.equals(obj)){
            return true;
        }

        return (this.getId().equals(((Product) obj).getId()));
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public String toString() {
        return ("Product id:"+this.getId()+"\tName:"+this.getName()
        +"\tCctegory:"+this.getCategory()+"\tDescription:"+this.getDescription()
        +"\tPrice:"+this.getPrice()+"\tImagePath:"+this.getImageUrl());
    }
}