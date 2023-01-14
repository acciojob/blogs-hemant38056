package com.driver.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;


    private Date pubdate;



    public Blog(){

    }

    public Blog(String title, String content, Date pubdate){
        this.title = title;
        this.content = content;
        this.pubdate = pubdate;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }





    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Date getPubdate() {
        return pubdate;
    }
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }












    @ManyToOne
    @JoinColumn
    public com.driver.models.User user;

    public User getUser(){
        return user;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }


    public void setUser(com.driver.models.User user) {
        this.user = user;
    }
}