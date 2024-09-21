package sn.ksi.gestion_boutique_kassi.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double montant;
    private boolean isPaid = false;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "dette", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();


    public List<LocalDate> getDatePaiement() {
        List<LocalDate> dates = new ArrayList<>();
        for (Paiement paiement : paiements) {
            dates.add(paiement.getDate());
        }
        return dates;
    }
}
