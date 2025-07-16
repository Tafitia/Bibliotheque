package com.bibliotheque.model.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PenalityDTO {
    private Long id;
    
    @JsonProperty("date_debut")
    private LocalDate startDate;
    
    @JsonProperty("date_fin")
    private LocalDate endDate;
    
    @JsonProperty("titre_livre")
    private String bookTitle;
    
    @JsonProperty("auteur_livre")
    private String bookAuthor;
    
    @JsonProperty("date_emprunt")
    private LocalDate loanDate;
    
    @JsonProperty("date_echeance")
    private LocalDate dueDate;

    public PenalityDTO() {}

    public PenalityDTO(Long id, LocalDate startDate, LocalDate endDate, String bookTitle, 
                      String bookAuthor, LocalDate loanDate, LocalDate dueDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getBookAuthor() { return bookAuthor; }
    public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }

    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
