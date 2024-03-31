package org.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClientService {
    @PersistenceContext
    private EntityManager entityManager;

    public Client createClient(String name) {
        Client client = new Client();
        client.setName(name);

        entityManager.persist(client);

        return client;
    }
}

