package sn.ksi.gestion_boutique_kassi.repository;

import sn.ksi.gestion_boutique_kassi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPhone(String phone);

}
