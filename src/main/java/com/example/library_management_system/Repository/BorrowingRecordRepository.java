package com.example.library_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library_management_system.Entity.Book;
import com.example.library_management_system.Entity.BorrowingRecord;
import com.example.library_management_system.Entity.Patron;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>{
    BorrowingRecord findByBookAndPatron(Book book, Patron patron);
}
