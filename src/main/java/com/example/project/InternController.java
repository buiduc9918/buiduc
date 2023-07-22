package com.example.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/interns/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable Long id, @RequestBody Intern updatedIntern) {
        // Implement code to update the intern with the given id using 'updatedIntern' data
        // Return ResponseEntity with appropriate status (e.g., HttpStatus.OK) and updated intern
        // Or return ResponseEntity with status HttpStatus.NOT_FOUND if intern with 'id' not found
        // Or handle any other business logic and return the appropriate response
        Intern intern = internManagementSystem.getInternById(id);

        if (intern == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the intern data with 'updatedIntern' data
        intern.setName(updatedIntern.getName());
        intern.setAge(updatedIntern.getAge());
        intern.setUniversity(updatedIntern.getUniversity());
        intern.setEmail(updatedIntern.getEmail());

        // Save the updated intern in the database or InternManagementSystem

        return new ResponseEntity<>(intern, HttpStatus.OK);
    }

    @DeleteMapping("/interns/{id}")
    public ResponseEntity<Void> deleteIntern(@PathVariable Long id) {
        // Implement code to delete the intern with the given id
        // Return ResponseEntity with appropriate status (e.g., HttpStatus.NO_CONTENT) on successful deletion
        // Or return ResponseEntity with status HttpStatus.NOT_FOUND if intern with 'id' not found
        // Or handle any other business logic and return the appropriate response
        Intern intern = internManagementSystem.getInternById(id);

        if (intern == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Delete the intern from the database or InternManagementSystem

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
