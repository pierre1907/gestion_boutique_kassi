package sn.ksi.gestion_boutique_kassi.service.impl;

import sn.ksi.gestion_boutique_kassi.model.Dette;
import sn.ksi.gestion_boutique_kassi.repository.DetteRepository;
import sn.ksi.gestion_boutique_kassi.service.IDetteService;
import sn.ksi.gestion_boutique_kassi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetteService implements IDetteService {

    @Autowired
    private DetteRepository detteRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Dette createDette(Long clientId, Dette dette) {
        var client = clientRepository.findById(clientId).orElse(null);
        if (client != null) {
            dette.setClient(client);
            return detteRepository.save(dette);
        }
        return null;
    }

    @Override
    public List<Dette> getDettesByClientId(Long clientId) {
        return detteRepository.findByClientId(clientId);
    }

    @Override
    public Dette updateDette(Long id, Dette dette) {
        dette.setId(id);
        return detteRepository.save(dette);
    }

    @Override
    public void deleteDette(Long id) {
        detteRepository.deleteById(id);
    }
}
