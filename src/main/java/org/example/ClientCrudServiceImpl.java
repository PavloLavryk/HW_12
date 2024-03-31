package org.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ClientCrudServiceImpl implements ClientCrudService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client create(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        return entityManager.merge(client);
    }

    @Override
    public void delete(Integer id) {
        Client client = findById(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }

    @Override
    public Client findById(Integer id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}

