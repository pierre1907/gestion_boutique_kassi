package sn.ksi.gestion_boutique_kassi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ksi.gestion_boutique_kassi.model.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
