package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
       return blogRepository1.findAll();

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        //updating the blog details

        //Updating the userInformation and changing its blogs


       Blog blog = new Blog();
       User user = userRepository1.findById(userId).get();

       // updating the blog details
        blog.setUser(user);
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());

        // updating the user information and changing its blogs
        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);

        //Only calling the parent userRepository function as the child function will automatically be called by cascading
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog

        return  blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it

//        Blog tempBlog = blogRepository1.findById(blogId).get();
//
//        Image tempImage = imageService1.createAndReturn(tempBlog, description, dimensions);
//
//        tempImage.setBlog(tempBlog);
//
//        List<Image> listOfImages = tempBlog.getImageList();
//
//        if(listOfImages == null){
//            listOfImages = new ArrayList<>();
//        }
//
//        listOfImages.add(tempImage);
//
//        tempBlog.setImageList(listOfImages);
//
//        blogRepository1.save(tempBlog);

        Blog blog = blogRepository1.findById(blogId).get();
        Image image = imageService1.createAndReturn(blog, description, dimensions);

        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);

        blogRepository1.save(blog);//Just calling the parent repository and child repository will automatically be called.

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        if(blogRepository1.findById(blogId).get() != null){
            blogRepository1.deleteById(blogId);
        }


    }
}
