package sn.ksi.gestion_boutique_kassi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String phone;
    private String address;
    private Double totalDue = 0.0;
    private Boolean asAccount = false;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Dette> dettes = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private Utilisateur user;
}
