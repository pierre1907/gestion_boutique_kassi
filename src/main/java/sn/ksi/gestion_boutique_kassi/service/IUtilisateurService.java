package sn.ksi.gestion_boutique_kassi.service;

import sn.ksi.gestion_boutique_kassi.model.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    Utilisateur createUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> listUtilisateurs();

    Utilisateur getUtilisateurById(Long id);

    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);

    void deleteUtilisateur(Long id);
}
