package sn.ksi.gestion_boutique_kassi.service.impl;

import sn.ksi.gestion_boutique_kassi.model.Client;
import sn.ksi.gestion_boutique_kassi.repository.ClientRepository;
import sn.ksi.gestion_boutique_kassi.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientByPhone(String phone){
        return clientRepository.findByPhone(phone);
    }

}
