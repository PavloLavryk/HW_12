package org.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PlanetCrudServiceImpl implements PlanetCrudService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Planet create(Planet planet) {
        entityManager.persist(planet);
        return planet;
    }

    @Override
    public Planet update(Planet planet) {
        return entityManager.merge(planet);
    }

    @Override
    public void delete(String id) {
        Planet planet = findById(id);
        if (planet != null) {
            entityManager.remove(planet);
        }
    }

    @Override
    public Planet findById(String id) {
        return entityManager.find(Planet.class, id);
    }

    @Override
    public List<Planet> findAll() {
        return entityManager.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }
}

