package sn.ksi.gestion_boutique_kassi.controller;

import sn.ksi.gestion_boutique_kassi.enums.RoleEnum;
import sn.ksi.gestion_boutique_kassi.model.Client;
import sn.ksi.gestion_boutique_kassi.model.Role;
import sn.ksi.gestion_boutique_kassi.model.Utilisateur;
import sn.ksi.gestion_boutique_kassi.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ksi.gestion_boutique_kassi.service.IRole;
import sn.ksi.gestion_boutique_kassi.service.IUtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IUtilisateurService utilisateurService;

    @Autowired
    private IRole roleService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        if (client.getAsAccount() != null && client.getAsAccount()) {
            Utilisateur utilisateur = new Utilisateur();

            // Vérifie si l'utilisateur existe et copie les valeurs
            if (client.getUser() != null && client.getUser().getRole() != null) {
                utilisateur.setEmail(client.getUser().getEmail());
                utilisateur.setLogin(client.getUser().getLogin());
                utilisateur.setPassword(client.getUser().getPassword());
                utilisateur.setPhoto(client.getUser().getPhoto());

                Long roleId = client.getUser().getRole().getId();
                Role role = roleService.getRoleById(roleId);
                utilisateur.setRole(role);
            } else {
                throw new IllegalArgumentException("User or role cannot be null");
            }

            utilisateurService.createUtilisateur(utilisateur);
            client.setUser(utilisateur);
        }

        Client savedClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }



    @GetMapping
    public ResponseEntity<List<Client>> listClients() {
        List<Client> clients = clientService.listClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
