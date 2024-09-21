package sn.ksi.gestion_boutique_kassi.service;

import sn.ksi.gestion_boutique_kassi.model.Role;
import sn.ksi.gestion_boutique_kassi.enums.RoleEnum;

public interface IRole {
    Role getRoleByEnum(RoleEnum roleEnum);
    Role getRoleById(Long id);
}
