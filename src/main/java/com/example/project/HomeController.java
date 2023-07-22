package com.example.project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home"; // Return the name of the home.html template
    }
}
