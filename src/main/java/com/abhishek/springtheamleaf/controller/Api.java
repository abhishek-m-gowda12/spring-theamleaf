package com.abhishek.springtheamleaf.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping
public class Api {

    @GetMapping
    public String getHtml(Model model) {
        model.addAttribute("message", "HI There");
        model.addAttribute("imagePath", getImageInBytes("images/iron-man.png"));
        return "index";
    }

    public static String getImageInBytes(String classPath) {
        String encodedFile = null;

        try {
            ClassPathResource classPathResource = new ClassPathResource(classPath);
            byte[] bytes = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            encodedFile = new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            // Ignored Intentionally
            e.printStackTrace();
        }
        return encodedFile;
    }
}
