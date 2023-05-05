package com.example.learn_spring_security.Controller;

import com.example.learn_spring_security.ulti.CrossOriginSite;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @CrossOrigin(origins = CrossOriginSite.CORS_SITE)
    @Secured({"USER"})
    @GetMapping("/hello")
    public String hellWorld() {
        return "Hello World";
    }
}
