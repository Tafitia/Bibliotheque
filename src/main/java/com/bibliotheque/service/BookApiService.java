package com.bibliotheque.service;

import com.bibliotheque.model.Book;
import com.bibliotheque.model.Copy;
import com.bibliotheque.model.Loan;
import com.bibliotheque.model.dto.BookWithCopiesDTO;
import com.bibliotheque.model.dto.CopyDTO;
import com.bibliotheque.repository.BookRepository;
import com.bibliotheque.repository.CopyRepository;
import com.bibliotheque.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookApiService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private LoanRepository loanRepository;

    public List<BookWithCopiesDTO> getAllBooksWithCopies() {
        return getAllBooksWithCopiesAtDate(LocalDate.now());
    }

    public List<BookWithCopiesDTO> getAllBooksWithCopiesAtDate(LocalDate checkDate) {
        List<Book> books = bookRepository.findAll();
        
        return books.stream()
                .map(book -> convertToBookWithCopiesDTO(book, checkDate))
                .collect(Collectors.toList());
    }

    public BookWithCopiesDTO getBookWithCopiesById(Long bookId) {
        return getBookWithCopiesById(bookId, LocalDate.now());
    }

    public BookWithCopiesDTO getBookWithCopiesById(Long bookId, LocalDate checkDate) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé avec l'ID: " + bookId));
        
        return convertToBookWithCopiesDTO(book, checkDate);
    }

    private BookWithCopiesDTO convertToBookWithCopiesDTO(Book book) {
        return convertToBookWithCopiesDTO(book, LocalDate.now());
    }

    private BookWithCopiesDTO convertToBookWithCopiesDTO(Book book, LocalDate checkDate) {
        List<Copy> copies = copyRepository.findByBookId(book.getId());
        List<CopyDTO> copyDTOs = copies.stream()
                .map(copy -> convertToCopyDTO(copy, checkDate))
                .collect(Collectors.toList());

        return new BookWithCopiesDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor() != null ? book.getAuthor().getName() : "Auteur inconnu",
                book.getBookGenre() != null ? book.getBookGenre().getValue() : "Genre inconnu",
                book.getEditionDate(),
                book.getAge(),
                copyDTOs
        );
    }

    private CopyDTO convertToCopyDTO(Copy copy) {
        return convertToCopyDTO(copy, LocalDate.now());
    }

    private CopyDTO convertToCopyDTO(Copy copy, LocalDate checkDate) {
        // Vérifier si l'exemplaire est disponible à la date donnée
        boolean isAvailable = isBookCopyAvailableAtDate(copy.getId(), checkDate);
        String status = isAvailable ? "Disponible" : "Emprunté";

        return new CopyDTO(
                copy.getId(),
                copy.getCopyId(),
                status,
                isAvailable
        );
    }

    private boolean isBookCopyAvailable(Long copyId) {
        return isBookCopyAvailableAtDate(copyId, LocalDate.now());
    }

    private boolean isBookCopyAvailableAtDate(Long copyId, LocalDate checkDate) {
        // Utiliser la méthode existante pour vérifier les conflits de date
        return !loanRepository.existsByCopyIdAndDateConflict(copyId, checkDate);
    }
}
