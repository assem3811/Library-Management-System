package com.example.library_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management_system.Entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long>{
    
}
