package com.bibliotheque.repository;

import com.bibliotheque.model.Penality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PenalityRepository extends JpaRepository<Penality, Long> {
    @Query("SELECT p FROM Penality p WHERE p.member.id = :memberId ORDER BY p.startDate DESC")
    List<Penality> findByMemberIdOrderByStartDateDesc(@Param("memberId") Long memberId);

    @Query("SELECT p FROM Penality p WHERE p.member.id = :memberId AND p.endDate >= CURRENT_DATE ORDER BY p.startDate DESC")
    List<Penality> findActivePenaltiesByMemberId(@Param("memberId") Long memberId);
}
