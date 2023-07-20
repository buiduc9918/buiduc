package com.example.project;

public class TestInternManagementSystem {
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
