package com.example.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Intern, Long> {
    // You can add custom query methods here if needed
}