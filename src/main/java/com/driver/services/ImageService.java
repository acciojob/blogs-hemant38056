package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image tempImage = new Image(description,dimensions);
        tempImage.setBlog(blog);

        List<Image> ans = blog.getImageList();
        if(ans == null){
            ans = new ArrayList<>();
        }
        ans.add(tempImage);


        blog.setImageList(ans);

        imageRepository2.save(tempImage);

        blogRepository.save(blog);

        return tempImage;
    }

    public void deleteImage(Image image){
        imageRepository2.delete(image);
    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

        if(screenDimensions.split("X").length == 2 || Objects.nonNull(image)){
            int length = Integer.parseInt(screenDimensions.split("X")[0] ) / Integer.parseInt(image.getDimension().split("X")[0]);
            int breadth = Integer.parseInt(screenDimensions.split("X")[1]) / Integer.parseInt(image.getDimension().split("X")[1]);

            return length * breadth;
        }
        return 0;

    }
}
