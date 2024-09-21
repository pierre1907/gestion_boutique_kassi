package sn.ksi.gestion_boutique_kassi.service.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;
import sn.ksi.gestion_boutique_kassi.model.Dette;

import java.util.List;

@Service
public class ArchiveServiceMongo {

    private final MongoClient mongoClient;

    public ArchiveServiceMongo(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void archiveDettes(List<Dette> dettes) {
        MongoDatabase database = mongoClient.getDatabase("myMongoDB");
        for (Dette dette : dettes) {
            Document doc = new Document("id", dette.getId())
                    .append("montant", dette.getMontant())
                    .append("datePaiement", dette.getDatePaiement());
            database.getCollection("archiveDettes").insertOne(doc);
        }
    }
}
