package sn.ksi.gestion_boutique_kassi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.ksi.gestion_boutique_kassi.model.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String login;
    private String password;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
