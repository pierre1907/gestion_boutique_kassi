package sn.ksi.gestion_boutique_kassi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sn.ksi.gestion_boutique_kassi.model.Dette;

import java.util.List;

@Service
public class ArchiveDetteService {

    private final ArchiveServiceMongo archiveServiceMongo;
    private final ArchiveServiceFirebase archiveServiceFirebase;

    public ArchiveDetteService(ArchiveServiceMongo archiveServiceMongo, ArchiveServiceFirebase archiveServiceFirebase) {
        this.archiveServiceMongo = archiveServiceMongo;
        this.archiveServiceFirebase = archiveServiceFirebase;
    }

    // Cron job qui s'exécute chaque jour à 23h
    @Scheduled(cron = "0 0 23 * * ?")
    public void archiverDettes() {

        List<Dette> dettesSoldees = recupererDettesSoldees();
        archiveServiceMongo.archiveDettes(dettesSoldees);
        archiveServiceFirebase.archiveDettes(dettesSoldees);
        supprimerDettesSoldees(dettesSoldees);

    }

    private List<Dette> recupererDettesSoldees() {
        return List.of();
    }

    private void supprimerDettesSoldees(List<Dette> dettes) {
    }
}
