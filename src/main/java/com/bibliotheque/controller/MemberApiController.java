package com.bibliotheque.controller;

import com.bibliotheque.model.dto.MemberDetailsDTO;
import com.bibliotheque.service.MemberApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    @Autowired
    private MemberApiService memberApiService;

    @GetMapping("/{memberId}")
    public ResponseEntity<?> getMemberDetails(@PathVariable Long memberId) {
        try {
            MemberDetailsDTO memberDetails = memberApiService.getMemberDetails(memberId);
            return ResponseEntity.ok(memberDetails);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("erreur", "Membre non trouvé");
            errorResponse.put("message", "Aucun membre trouvé avec l'ID: " + memberId);
            return ResponseEntity.status(404).body(errorResponse);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("erreur", "Erreur interne du serveur");
            errorResponse.put("message", "Une erreur inattendue s'est produite");
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}
