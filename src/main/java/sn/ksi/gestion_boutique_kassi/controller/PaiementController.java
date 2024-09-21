package sn.ksi.gestion_boutique_kassi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ksi.gestion_boutique_kassi.model.Paiement;
import sn.ksi.gestion_boutique_kassi.service.impl.PaiementService;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public ResponseEntity<Paiement> enregistrerPaiement(@RequestBody Paiement paiement) {
        Paiement nouveauPaiement = paiementService.enregistrerPaiement(paiement);
        return ResponseEntity.ok(nouveauPaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerPaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.ok().build();
    }

}
