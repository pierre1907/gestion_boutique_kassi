package sn.ksi.gestion_boutique_kassi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ksi.gestion_boutique_kassi.model.Role;
import sn.ksi.gestion_boutique_kassi.enums.RoleEnum;
import sn.ksi.gestion_boutique_kassi.repository.RoleRepository;
import sn.ksi.gestion_boutique_kassi.service.IRole;

import java.util.Optional;

@Service
public class RoleService implements IRole {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByEnum(RoleEnum roleEnum) {
        Optional<Role> role = roleRepository.findByName(roleEnum.name());
        return role.orElseThrow(() -> new RuntimeException("Rôle non trouvé: " + roleEnum.name()));
    }
}
