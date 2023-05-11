package org.example.repository;

import org.example.entity.GenreJPA;

import javax.persistence.EntityManagerFactory;

public class GenreRepository extends AbstractRepository<GenreJPA>{

    public GenreRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<GenreJPA> getEntityClass() {
        return GenreJPA.class;
    }
}
