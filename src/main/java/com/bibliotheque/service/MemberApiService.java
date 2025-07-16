package com.bibliotheque.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.model.*;
import com.bibliotheque.model.dto.MemberDetailsDTO;
import com.bibliotheque.model.dto.PenalityDTO;
import com.bibliotheque.repository.*;

@Service
public class MemberApiService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private PenalityRepository penalityRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private MemberQuotaLoanRepository memberQuotaLoanRepository;

    @Autowired
    private MemberQuotaReservationRepository memberQuotaReservationRepository;

    @Autowired
    private MemberQuotaExtensionRepository memberQuotaExtensionRepository;

    @Transactional(readOnly = true)
    public MemberDetailsDTO getMemberDetails(Long memberId) {
        System.out.println("MemberApiService.getMemberDetails appelé avec memberId: " + memberId);
        // Récupérer le membre
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("Membre non trouvé avec l'ID: " + memberId));

        // Récupérer l'abonnement actuel
        Subscription currentSubscription = subscriptionRepository
            .findFirstByMemberIdOrderBySubscriptionDateDesc(memberId)
            .orElse(null);

        // Récupérer les pénalités
        List<Penality> penalties = penalityRepository.findByMemberIdOrderByStartDateDesc(memberId);

        // Compter les prêts actifs
        int activeLoansCount = loanRepository.countActiveLoansByMemberId(memberId);

        // Calculer les quotas de base
        int baseLoanQuota = member.getMemberType().getQuotaLoan();
        int baseReservationQuota = member.getMemberType().getQuotaReservation();
        int baseExtensionQuota = member.getMemberType().getQuotaExtension();

        // Récupérer les variations de quota (bonus/malus appliqués au membre)
        // Pour l'instant, on met à 0 car ces tables semblent vides ou non utilisées
        int loanVariation = 0; // memberQuotaLoanRepository.getTotalQuotaVariationByMemberId(memberId);
        int reservationVariation = 0; // memberQuotaReservationRepository.getTotalQuotaVariationByMemberId(memberId);
        int extensionVariation = 0; // memberQuotaExtensionRepository.getTotalQuotaVariationByMemberId(memberId);

        // Debug: afficher les valeurs calculées
        System.out.println("=== DEBUG QUOTAS MEMBRE " + memberId + " ===");
        System.out.println("Quotas de base - Emprunts: " + baseLoanQuota + ", Réservations: " + baseReservationQuota + ", Extensions: " + baseExtensionQuota);
        System.out.println("Variations - Emprunts: " + loanVariation + ", Réservations: " + reservationVariation + ", Extensions: " + extensionVariation);
        System.out.println("Emprunts actifs: " + activeLoansCount);

        // Calculer les quotas totaux (quota de base + variations)
        int totalLoanQuota = baseLoanQuota + loanVariation;
        int totalReservationQuota = baseReservationQuota + reservationVariation;
        int totalExtensionQuota = baseExtensionQuota + extensionVariation;

        System.out.println("Quotas totaux - Emprunts: " + totalLoanQuota + ", Réservations: " + totalReservationQuota + ", Extensions: " + totalExtensionQuota);

        // Calculer les quotas restants (quota total - utilisation actuelle)
        int remainingLoans = Math.max(0, totalLoanQuota - activeLoansCount);
        
        // TODO: Ajouter le comptage des réservations et extensions actives
        // Pour l'instant, on suppose qu'il n'y en a pas
        int activeReservationsCount = 0; // À implémenter avec ReservationRepository
        int activeExtensionsCount = 0;   // À implémenter avec ExtensionRepository
        
        int remainingReservations = Math.max(0, totalReservationQuota - activeReservationsCount);
        int remainingExtensions = Math.max(0, totalExtensionQuota - activeExtensionsCount);

        // Construire la liste des PenalityDTO
        List<PenalityDTO> penalityDTOs = penalties.stream()
            .map(this::mapPenalityToDTO)
            .collect(Collectors.toList());

        // Construire le DTO principal avec les nouvelles données structurées
        MemberDetailsDTO dto = new MemberDetailsDTO();
        dto.setId(member.getId());
        dto.setUsername(member.getUsername());
        dto.setEmail(member.getEmail());
        dto.setBirth(member.getBirth());
        dto.setRegistrationDate(member.getRegistrationDate());
        dto.setMemberTypeName(member.getMemberType().getValue());
        dto.setLoanDuration(member.getMemberType().getLoanDuration());
        dto.setExtensionDuration(member.getMemberType().getExtensionDuration());
        dto.setPenalityDuration(member.getMemberType().getPenalityDuration());
        
        // Informations d'abonnement
        if (currentSubscription != null) {
            dto.setSubscriptionTypeName(currentSubscription.getSubscriptionType().getName());
            dto.setSubscriptionStart(currentSubscription.getSubscriptionStart());
            dto.setSubscriptionEnd(currentSubscription.getSubscriptionEnd());
        }
        
        // Quotas de base
        dto.setQuotaLoan(baseLoanQuota);
        dto.setQuotaReservation(baseReservationQuota);
        dto.setQuotaExtension(baseExtensionQuota);
        
        // Quotas totaux
        dto.setTotalLoanQuota(totalLoanQuota);
        dto.setTotalReservationQuota(totalReservationQuota);
        dto.setTotalExtensionQuota(totalExtensionQuota);
        
        // Utilisation actuelle
        dto.setActiveLoansCount(activeLoansCount);
        dto.setActiveReservationsCount(activeReservationsCount);
        dto.setActiveExtensionsCount(activeExtensionsCount);
        
        // Quotas restants
        dto.setRemainingLoans(remainingLoans);
        dto.setRemainingReservations(remainingReservations);
        dto.setRemainingExtensions(remainingExtensions);
        
        // Pénalités
        dto.setPenalties(penalityDTOs);
        
        return dto;
    }

    private PenalityDTO mapPenalityToDTO(Penality penality) {
        String bookTitle = null;
        String bookAuthor = null;
        java.time.LocalDate loanDate = null;
        java.time.LocalDate dueDate = null;

        if (penality.getLoan() != null) {
            Loan loan = penality.getLoan();
            loanDate = loan.getLoanDate();
            dueDate = loan.getDueDate();

            if (loan.getCopy() != null && loan.getCopy().getBook() != null) {
                Book book = loan.getCopy().getBook();
                bookTitle = book.getTitle();
                if (book.getAuthor() != null) {
                    bookAuthor = book.getAuthor().getName();
                }
            }
        }

        return new PenalityDTO(
            penality.getId(),
            penality.getstartDate(),
            penality.getendDate(),
            bookTitle,
            bookAuthor,
            loanDate,
            dueDate
        );
    }
}
