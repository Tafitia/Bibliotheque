package com.bibliotheque.model.dto;

import java.time.LocalDate;
import java.util.List;

public class BookWithCopiesDTO {
    private Long id;
    private String title;
    private String authorName;
    private String genre;
    private LocalDate editionDate;
    private Integer age;
    private List<CopyDTO> copies;

    public BookWithCopiesDTO() {}

    public BookWithCopiesDTO(Long id, String title, String authorName, String genre, 
                            LocalDate editionDate, Integer age, List<CopyDTO> copies) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.editionDate = editionDate;
        this.age = age;
        this.copies = copies;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public LocalDate getEditionDate() { return editionDate; }
    public void setEditionDate(LocalDate editionDate) { this.editionDate = editionDate; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public List<CopyDTO> getCopies() { return copies; }
    public void setCopies(List<CopyDTO> copies) { this.copies = copies; }
}
