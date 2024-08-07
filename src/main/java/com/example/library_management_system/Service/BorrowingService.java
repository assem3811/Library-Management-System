package com.example.library_management_system.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Entity.Book;
import com.example.library_management_system.Entity.BorrowingRecord;
import com.example.library_management_system.Entity.Patron;
import com.example.library_management_system.Repository.BookRepository;
import com.example.library_management_system.Repository.BorrowingRecordRepository;
import com.example.library_management_system.Repository.PatronRepository;

import jakarta.transaction.Transactional;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Patron patron = patronRepository.findById(patronId).orElseThrow();
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found"));
        Patron patron = patronRepository.findById(patronId)
            .orElseThrow(() -> new RuntimeException("Patron not found"));

        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookAndPatron(book, patron);
        if (borrowingRecord == null) {
            throw new RuntimeException("Borrowing record not found");
        }
        borrowingRecord.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }
}
