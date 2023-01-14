package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String description;

    String dimension;

    public Image(){

    }

    public Image(String description, String dimension){
        this.description = description;
        this.dimension = dimension;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension() {
        return dimension;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }


    @ManyToOne
    @JoinColumn
    public Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}