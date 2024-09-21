package sn.ksi.gestion_boutique_kassi.repository;

import sn.ksi.gestion_boutique_kassi.model.Dette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetteRepository extends JpaRepository<Dette, Long> {
    List<Dette> findByClientId(Long clientId);
}
