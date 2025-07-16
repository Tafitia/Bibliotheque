package com.bibliotheque.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CopyDTO {
    private Long id;
    
    @JsonProperty("numero_exemplaire")
    private Integer copyId;
    
    @JsonProperty("statut")
    private String status;
    
    @JsonProperty("disponible")
    private boolean isAvailable;

    public CopyDTO() {}

    public CopyDTO(Long id, Integer copyId, String status, boolean isAvailable) {
        this.id = id;
        this.copyId = copyId;
        this.status = status;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCopyId() { return copyId; }
    public void setCopyId(Integer copyId) { this.copyId = copyId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
