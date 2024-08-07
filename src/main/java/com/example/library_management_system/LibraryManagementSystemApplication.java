package com.example.library_management_system;

import java.time.Year;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.library_management_system.Entity.Book;
import com.example.library_management_system.Entity.Patron;
import com.example.library_management_system.Repository.BookRepository;
import com.example.library_management_system.Repository.PatronRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	//Dummy Data Generator
	@Bean
	public CommandLineRunner loadData(BookRepository bookRepository, PatronRepository patronRepository) {
		return (args) -> {
			Faker faker = new Faker();

			// Generate Books Dummy Data
			for(int i=0; i<5; i++) {
				String author = faker.book().author();
                Year publicationYear = Year.of(faker.number().numberBetween(1900, 2024));
                String isbn = faker.code().isbn10();

                Book book = new Book();
                book.setAuthor(author);
                book.setPublicationYear(publicationYear);
                book.setIsbn(isbn);

                bookRepository.save(book);
			}

			for(int i=0; i<5; i++) {
				String name = faker.name().fullName();
				String contactInfo = faker.phoneNumber().phoneNumber();

				Patron patron = new Patron();
				patron.setName(name);
				patron.setContactInfo(contactInfo);

				patronRepository.save(patron);
			}
		};
	}
}
