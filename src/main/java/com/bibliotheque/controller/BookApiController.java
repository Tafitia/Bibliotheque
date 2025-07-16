package com.bibliotheque.controller;

import com.bibliotheque.model.dto.BookWithCopiesDTO;
import com.bibliotheque.service.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    public ResponseEntity<?> getBookWithCopiesById(
            @PathVariable Long bookId,
            @RequestParam(value = "date", required = false) 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            LocalDate checkDate = date != null ? date : LocalDate.now();
            BookWithCopiesDTO book = bookApiService.getBookWithCopiesById(bookId, checkDate);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("erreur", "Livre non trouvé");
            errorResponse.put("message", "Aucun livre trouvé avec l'ID: " + bookId);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("erreur", "Erreur interne du serveur");
            errorResponse.put("message", "Une erreur inattendue s'est produite");
            return ResponseEntity.status(500).body(errorResponse);
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
