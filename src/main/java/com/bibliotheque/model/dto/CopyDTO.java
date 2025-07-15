package com.bibliotheque.model.dto;

public class CopyDTO {
    private Long id;
    private Integer copyId;
    private String status;
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
