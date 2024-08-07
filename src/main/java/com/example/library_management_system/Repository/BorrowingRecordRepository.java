package com.example.library_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management_system.Entity.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>{
    BorrowingRecord findByBookAndPatron(Long bookId, Long patronId);
}
