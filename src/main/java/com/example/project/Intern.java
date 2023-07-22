package com.example.project;


public class Intern {
    private String name ;
    private int age;
    private String university;
    private String email ;

    // Constructor
    public Intern(String name, int age, String university, String email) {
        this.name = name;
        this.age = age;
        this.university = university;
        this.email = email;
}
 public void setAge(int age) {
     this.age = age;
 }
 public void setEmail(String email) {
     this.email = email;
 }
 public void setName(String name) {
     this.name = name;
 }
 public void setUniversity(String university) {
     this.university = university;
 }
 public int getAge() {
     return age;
 }
 public String getEmail() {
     return email;
 }
 public String getName() {
     return name;
 }
 public String getUniversity() {
     return university;
 }
}