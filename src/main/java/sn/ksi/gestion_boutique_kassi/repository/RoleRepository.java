package sn.ksi.gestion_boutique_kassi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ksi.gestion_boutique_kassi.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}
