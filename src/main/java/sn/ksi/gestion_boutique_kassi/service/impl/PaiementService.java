package sn.ksi.gestion_boutique_kassi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ksi.gestion_boutique_kassi.model.Paiement;
import sn.ksi.gestion_boutique_kassi.repository.PaiementRepository;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    public Paiement enregistrerPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement deletePaiement(Long id) {
        Paiement paiement = paiementRepository.findById(id).orElse(null);
        if (paiement != null) {
            paiementRepository.delete(paiement);
        }
        return paiement;
    }
}
