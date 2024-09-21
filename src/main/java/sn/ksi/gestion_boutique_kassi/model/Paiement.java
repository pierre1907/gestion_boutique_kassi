package sn.ksi.gestion_boutique_kassi.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "dette_id", nullable = false)
    private Dette dette;
}
