package sn.ksi.gestion_boutique_kassi.repository;

import sn.ksi.gestion_boutique_kassi.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
