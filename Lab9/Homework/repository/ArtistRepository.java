package org.example.repository;


import org.example.entity.ArtistJPA;

import javax.persistence.EntityManagerFactory;

public class ArtistRepository extends AbstractRepository<ArtistJPA>{

    public ArtistRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<ArtistJPA> getEntityClass() {
        return ArtistJPA.class;
    }

}
