package com.show_images.controller;

import com.show_images.model.Image;
import com.show_images.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {
	
	@Autowired
    ImageRepository imageRepository;

	@GetMapping
    public final String hola() throws UnknownHostException {
        return "Hola! Puedes encontrarme en " + InetAddress.getLocalHost().getHostAddress();
    }
	
    @GetMapping("/images/{id_user}")
    public List<Image> getAllImagesPublic(@PathVariable(value = "id_user") String id_user, @RequestHeader("token") String token) {
    	if(token == null) {
    		return imageRepository.findByPrivacyAndIduser("0", id_user);
    	}else {
    		RestTemplate restTemplate = new RestTemplate();
    		String petition = "192.168.0.14:8080/" + token;
    		String id_user_token = restTemplate.getForObject(petition, String.class);
    		if (id_user == id_user_token) {
                return imageRepository.findByPrivacyAndIduser("1", id_user);
        	}else {
                return imageRepository.findByPrivacyAndIduser("0", id_user);
        	}
    	} 	   		
    }
}
