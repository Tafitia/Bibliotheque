package com.bibliotheque.controller;

import com.bibliotheque.model.dto.BookWithCopiesDTO;
import com.bibliotheque.service.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApiController {

    @Autowired
    private BookApiService bookApiService;


    @GetMapping
    public ResponseEntity<List<BookWithCopiesDTO>> getAllBooksWithCopies(
            @RequestParam(value = "date", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            LocalDate checkDate = date != null ? date : LocalDate.now();
            List<BookWithCopiesDTO> books = bookApiService.getAllBooksWithCopiesAtDate(checkDate);
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<BookWithCopiesDTO> getBookWithCopiesById(
            @PathVariable Long bookId,
            @RequestParam(value = "date", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            LocalDate checkDate = date != null ? date : LocalDate.now();
            BookWithCopiesDTO book = bookApiService.getBookWithCopiesById(bookId, checkDate);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<BookWithCopiesDTO>> getAvailableBooksWithCopies(
            @RequestParam(value = "date", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            LocalDate checkDate = date != null ? date : LocalDate.now();
            List<BookWithCopiesDTO> books = bookApiService.getAllBooksWithCopiesAtDate(checkDate);
            // Filtrer pour ne garder que les livres avec au moins un exemplaire disponible
            List<BookWithCopiesDTO> availableBooks = books.stream()
                    .filter(book -> book.getCopies().stream().anyMatch(copy -> copy.isAvailable()))
                    .toList();
            return ResponseEntity.ok(availableBooks);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/availability")
    public ResponseEntity<List<BookWithCopiesDTO>> getBooksAvailabilityAtDate(
            @RequestParam(value = "date") 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            List<BookWithCopiesDTO> books = bookApiService.getAllBooksWithCopiesAtDate(date);
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
