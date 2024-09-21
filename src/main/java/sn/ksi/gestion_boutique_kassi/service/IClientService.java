package sn.ksi.gestion_boutique_kassi.service;

import sn.ksi.gestion_boutique_kassi.model.Client;

import java.util.List;

public interface IClientService {
    Client createClient(Client client);

    List<Client> listClients();

    Client getClientById(Long id);

    Client updateClient(Long id, Client client);

    void deleteClient(Long id);

    Client getClientByPhone(String phone);
}
