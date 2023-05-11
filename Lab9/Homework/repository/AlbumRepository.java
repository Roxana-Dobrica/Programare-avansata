package org.example.repository;

import org.example.entity.AlbumJPA;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlbumRepository extends AbstractRepository<AlbumJPA>{

    public AlbumRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public List<AlbumJPA> findByTitle(String titlePattern) {
        return entityManager.createNamedQuery(getEntityClass().getSimpleName() + ".findByTitle")
                .setParameter("title", "%" + titlePattern +"%")
                .getResultList();
    }

    @Override
    public Class<AlbumJPA> getEntityClass() {
        return AlbumJPA.class;
    }
}
