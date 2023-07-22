package com.example.project;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class InternService {
    private final InternRepository internRepository;

    @Autowired
    public InternService(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

    public Intern getInternById(Long id) {
        return internRepository.findById(id).orElse(null);
    }

    public Intern saveIntern(Intern intern) {
        return internRepository.save(intern);
    }

    public void deleteIntern(Long id) {
        internRepository.deleteById(id);
    }
}
