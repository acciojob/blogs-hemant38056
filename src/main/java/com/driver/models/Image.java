//package com.driver.models;
//
//import javax.persistence.*;
//
//@Entity
//public class Image {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    String description;
//
//    String dimension;
//
//    public Image(){
//
//    }
//
//    public Image(String description, String dimension){
//        this.description = description;
//        this.dimension = dimension;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDimension() {
//        return dimension;
//    }
//    public void setDimension(String dimension) {
//        this.dimension = dimension;
//    }
//
//
//    @ManyToOne
//    @JoinColumn
//    public Blog blog;
//
//    public Blog getBlog() {
//        return blog;
//    }
//
//    public void setBlog(Blog blog) {
//        this.blog = blog;
//    }
//}

package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String dimensions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Image() {
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }
    @ManyToOne
    @JoinColumn
    private Blog blog;
}