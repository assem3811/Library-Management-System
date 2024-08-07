package com.example.library_management_system.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Entity.Patron;
import com.example.library_management_system.Repository.PatronRepository;

@Service
public class PatronService {
    
    @Autowired
    private PatronRepository patronRepository;

    //CRUD Functions...
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Optional<Patron> getPatronById(Long id) {
        return patronRepository.findById(id);
    }

    public Patron addNewPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patron) {
        patron.setId(id);
        return patronRepository.save(patron);
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
