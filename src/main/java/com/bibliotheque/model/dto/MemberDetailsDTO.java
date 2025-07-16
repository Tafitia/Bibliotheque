package com.bibliotheque.model.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberDetailsDTO {
    private Long id;
    
    @JsonProperty("nom_utilisateur")
    private String username;
    
    private String email;
    
    @JsonProperty("date_naissance")
    private LocalDate birth;
    
    @JsonProperty("date_inscription")
    private LocalDate registrationDate;
    
    @JsonProperty("type_membre")
    private String memberTypeName;
    
    @JsonProperty("duree_emprunt")
    private Integer loanDuration;
    
    @JsonProperty("duree_prolongation")
    private Integer extensionDuration;
    
    @JsonProperty("duree_penalite")
    private Integer penalityDuration;
    
    @JsonProperty("type_abonnement")
    private String subscriptionTypeName;
    
    @JsonProperty("debut_abonnement")
    private LocalDate subscriptionStart;
    
    @JsonProperty("fin_abonnement")
    private LocalDate subscriptionEnd;
    
    @JsonProperty("penalites")
    private List<PenalityDTO> penalties;
    
    // Quotas de base du type de membre
    @JsonProperty("quota_emprunts_base")
    private Integer quotaLoan;
    
    @JsonProperty("quota_reservations_base")
    private Integer quotaReservation;
    
    @JsonProperty("quota_prolongations_base")
    private Integer quotaExtension;
    
    // Quotas totaux (base + variations)
    @JsonProperty("quota_emprunts_total")
    private int totalLoanQuota;
    
    @JsonProperty("quota_reservations_total")
    private int totalReservationQuota;
    
    @JsonProperty("quota_prolongations_total")
    private int totalExtensionQuota;
    
    // Utilisation actuelle
    @JsonProperty("emprunts_actifs")
    private int activeLoansCount;
    
    @JsonProperty("reservations_actives")
    private int activeReservationsCount;
    
    @JsonProperty("prolongations_actives")
    private int activeExtensionsCount;
    
    // Quotas restants (total - utilisation actuelle)
    @JsonProperty("emprunts_restants")
    private int remainingLoans;
    
    @JsonProperty("reservations_restantes")
    private int remainingReservations;
    
    @JsonProperty("prolongations_restantes")
    private int remainingExtensions;

    // Constructors
    public MemberDetailsDTO() {}

    public MemberDetailsDTO(Long id, String username, String email, LocalDate birth, 
                           LocalDate registrationDate, String memberTypeName, Integer quotaLoan,
                           Integer quotaReservation, Integer quotaExtension, Integer loanDuration,
                           Integer extensionDuration, Integer penalityDuration, String subscriptionTypeName,
                           LocalDate subscriptionStart, LocalDate subscriptionEnd, List<PenalityDTO> penalties,
                           int activeLoansCount, int remainingLoans, int remainingReservations, 
                           int remainingExtensions) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birth = birth;
        this.registrationDate = registrationDate;
        this.memberTypeName = memberTypeName;
        this.quotaLoan = quotaLoan;
        this.quotaReservation = quotaReservation;
        this.quotaExtension = quotaExtension;
        this.loanDuration = loanDuration;
        this.extensionDuration = extensionDuration;
        this.penalityDuration = penalityDuration;
        this.subscriptionTypeName = subscriptionTypeName;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.penalties = penalties;
        this.activeLoansCount = activeLoansCount;
        this.remainingLoans = remainingLoans;
        this.remainingReservations = remainingReservations;
        this.remainingExtensions = remainingExtensions;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirth() { return birth; }
    public void setBirth(LocalDate birth) { this.birth = birth; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public String getMemberTypeName() { return memberTypeName; }
    public void setMemberTypeName(String memberTypeName) { this.memberTypeName = memberTypeName; }

    public Integer getQuotaLoan() { return quotaLoan; }
    public void setQuotaLoan(Integer quotaLoan) { this.quotaLoan = quotaLoan; }

    public Integer getQuotaReservation() { return quotaReservation; }
    public void setQuotaReservation(Integer quotaReservation) { this.quotaReservation = quotaReservation; }

    public Integer getQuotaExtension() { return quotaExtension; }
    public void setQuotaExtension(Integer quotaExtension) { this.quotaExtension = quotaExtension; }

    public Integer getLoanDuration() { return loanDuration; }
    public void setLoanDuration(Integer loanDuration) { this.loanDuration = loanDuration; }

    public Integer getExtensionDuration() { return extensionDuration; }
    public void setExtensionDuration(Integer extensionDuration) { this.extensionDuration = extensionDuration; }

    public Integer getPenalityDuration() { return penalityDuration; }
    public void setPenalityDuration(Integer penalityDuration) { this.penalityDuration = penalityDuration; }

    public String getSubscriptionTypeName() { return subscriptionTypeName; }
    public void setSubscriptionTypeName(String subscriptionTypeName) { this.subscriptionTypeName = subscriptionTypeName; }

    public LocalDate getSubscriptionStart() { return subscriptionStart; }
    public void setSubscriptionStart(LocalDate subscriptionStart) { this.subscriptionStart = subscriptionStart; }

    public LocalDate getSubscriptionEnd() { return subscriptionEnd; }
    public void setSubscriptionEnd(LocalDate subscriptionEnd) { this.subscriptionEnd = subscriptionEnd; }

    public List<PenalityDTO> getPenalties() { return penalties; }
    public void setPenalties(List<PenalityDTO> penalties) { this.penalties = penalties; }

    // Getters/Setters pour les quotas totaux
    public int getTotalLoanQuota() { return totalLoanQuota; }
    public void setTotalLoanQuota(int totalLoanQuota) { this.totalLoanQuota = totalLoanQuota; }

    public int getTotalReservationQuota() { return totalReservationQuota; }
    public void setTotalReservationQuota(int totalReservationQuota) { this.totalReservationQuota = totalReservationQuota; }

    public int getTotalExtensionQuota() { return totalExtensionQuota; }
    public void setTotalExtensionQuota(int totalExtensionQuota) { this.totalExtensionQuota = totalExtensionQuota; }

    // Getters/Setters pour l'utilisation actuelle
    public int getActiveLoansCount() { return activeLoansCount; }
    public void setActiveLoansCount(int activeLoansCount) { this.activeLoansCount = activeLoansCount; }

    public int getActiveReservationsCount() { return activeReservationsCount; }
    public void setActiveReservationsCount(int activeReservationsCount) { this.activeReservationsCount = activeReservationsCount; }

    public int getActiveExtensionsCount() { return activeExtensionsCount; }
    public void setActiveExtensionsCount(int activeExtensionsCount) { this.activeExtensionsCount = activeExtensionsCount; }

    // Getters/Setters pour les quotas restants
    public int getRemainingLoans() { return remainingLoans; }
    public void setRemainingLoans(int remainingLoans) { this.remainingLoans = remainingLoans; }

    public int getRemainingReservations() { return remainingReservations; }
    public void setRemainingReservations(int remainingReservations) { this.remainingReservations = remainingReservations; }

    public int getRemainingExtensions() { return remainingExtensions; }
    public void setRemainingExtensions(int remainingExtensions) { this.remainingExtensions = remainingExtensions; }
}
