package sn.ksi.gestion_boutique_kassi.controller;

import sn.ksi.gestion_boutique_kassi.enums.RoleEnum;
import sn.ksi.gestion_boutique_kassi.model.Role;
import sn.ksi.gestion_boutique_kassi.model.Utilisateur;
import sn.ksi.gestion_boutique_kassi.repository.UtilisateurRepository;
import sn.ksi.gestion_boutique_kassi.service.IRole;
import sn.ksi.gestion_boutique_kassi.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;

    @Autowired
    private IRole roleService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        RoleEnum roleEnum = RoleEnum.valueOf(utilisateur.getRole().getName());
        Role role = roleService.getRoleByEnum(roleEnum);
        utilisateur.setRole(role);
        Utilisateur savedUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUtilisateur);
    }



    @GetMapping
    public ResponseEntity<List<Utilisateur>> listUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.listUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur != null ? ResponseEntity.ok(utilisateur) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}
