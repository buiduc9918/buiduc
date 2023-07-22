package com.example.project;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternController {
    private final InternManagementSystem internManagementSystem;

    public InternController(InternManagementSystem internManagementSystem) {
        this.internManagementSystem = internManagementSystem;
    }

    @GetMapping("/interns")
    public String internsPage(Model model) {
        model.addAttribute("interns", internManagementSystem.getAllInterns());
        return "interns"; // Return the name of the interns.html template
    }
}
