package com.show_images.controller;

import com.show_images.model.Image;
import com.show_images.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
	
	@GetMapping("/images")
    public List<Image> getAllImagesPublic() {
        return imageRepository.findByPrivacy("1"); 	   		
	}
	
    @GetMapping("/images/{id_user}")
    public List<Image> getAllImagesPublic(@PathVariable(value = "id_user") String id_user) {
        return imageRepository.findByPrivacyAndIduser("0", id_user); 	   		
    }
}
