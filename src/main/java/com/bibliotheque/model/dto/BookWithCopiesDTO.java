package com.bibliotheque.model.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookWithCopiesDTO {
    private Long id;
    
    @JsonProperty("titre")
    private String title;
    
    @JsonProperty("nom_auteur")
    private String authorName;
    
    private String genre;
    
    @JsonProperty("date_edition")
    private LocalDate editionDate;
    
    @JsonProperty("age_requis")
    private Integer age;
    
    @JsonProperty("exemplaires")
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
