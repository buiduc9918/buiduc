package com.example.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InternManagementSystem {
    Intern intern ;
    private List<Intern> interns;
    public InternManagementSystem() {
        interns = new ArrayList<>();
    }

    // Add a new intern
    public void addIntern(Intern intern) {
        interns.add(intern);
    }

    // View all interns
    public void viewAllInterns() {
        for (Intern intern : interns) {
            System.out.println(intern.getName() + " | " + intern.getAge() + " | " + intern.getUniversity() + " | " + intern.getEmail());
        }
    }
    // Update intern details
    public void updateIntern(Intern intern, String newName, int newAge, String newUniversity, String newEmail) {
        intern.setName(newName);
        intern.setAge(newAge);
        intern.setUniversity(newUniversity);
        intern.setEmail(newEmail);
    }

    // Remove an intern
    public void removeIntern(Intern intern) {
        interns.remove(intern);
    }

    public Object getAllInterns() {
        return interns;
    }   
    public static void main(String[] args) {
        InternManagementSystem internSystem = new InternManagementSystem();

        // Add new interns
        Intern intern1 = new Intern("John Doe", 22, "ABC University", "john.doe@example.com");
        Intern intern2 = new Intern("Jane Smith", 23, "XYZ University", "jane.smith@example.com");
        
        internSystem.addIntern(intern1);
        internSystem.addIntern(intern2);

        // View all interns
        System.out.println("All Interns:");
        internSystem.viewAllInterns();

        // Update intern details
        internSystem.updateIntern(intern1, "John Updated", 23, "DEF University", "john.updated@example.com");

        // View all interns after updating
        System.out.println("\nAll Interns after update:");
        internSystem.viewAllInterns();

        // Remove an intern
        internSystem.removeIntern(intern2);

        // View all interns after removal
        System.out.println("\nAll Interns after removal:");
        internSystem.viewAllInterns();
        
        // Accessing intern properties using getter methods
        System.out.println("Name: " + intern1.getName());
        System.out.println("Age: " + intern1.getAge());
        System.out.println("University: " + intern1.getUniversity());
        System.out.println("Email: " + intern1.getEmail());
    }
}
