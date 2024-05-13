package com.ERP.services;
import com.ERP.entities.Client;
import com.ERP.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }
}
