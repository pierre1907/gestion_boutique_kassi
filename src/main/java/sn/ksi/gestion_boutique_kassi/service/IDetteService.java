package sn.ksi.gestion_boutique_kassi.service;

import sn.ksi.gestion_boutique_kassi.model.Dette;

import java.util.List;

public interface IDetteService {
    Dette createDette(Long clientId, Dette dette);

    List<Dette> getDettesByClientId(Long clientId);

    Dette updateDette(Long id, Dette dette);

    void deleteDette(Long id);
}
