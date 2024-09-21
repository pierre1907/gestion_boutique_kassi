package sn.ksi.gestion_boutique_kassi.service.impl;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import sn.ksi.gestion_boutique_kassi.model.Dette;

import java.util.List;

@Service
public class ArchiveServiceFirebase {

    public void archiveDettes(List<Dette> dettes) {
        Firestore firestore = FirestoreClient.getFirestore();
        for (Dette dette : dettes) {
            firestore.collection("archiveDettes")
                    .document(dette.getId().toString())
                    .set(dette);
        }
    }
}
