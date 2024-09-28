package ru.razum0ff.sqlpostgrestest.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class NameIdRepository {

    final
    EntityManager entityManager;

    public NameIdRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getNameByKod(Short kod){
        String name = (String) entityManager
                .createNativeQuery("SELECT ni.name FROM test.name_id ni WHERE ni.kod = :kod", String.class)
                .setParameter("kod", kod)
                .setMaxResults(1)
                .getSingleResult();
        return name;
    }
}
