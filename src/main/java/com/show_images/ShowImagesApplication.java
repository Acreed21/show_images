package com.show_images;

import com.show_images.model.Image;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.show_images.repository.ImageRepository;

@SpringBootApplication
@EnableJpaAuditing

@ComponentScan(basePackageClasses = ImageRepository.class)
@ComponentScan(basePackageClasses = Image.class)
public class ShowImagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowImagesApplication.class, args);
    }
    
}