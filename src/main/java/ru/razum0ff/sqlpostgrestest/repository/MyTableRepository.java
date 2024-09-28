package ru.razum0ff.sqlpostgrestest.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.razum0ff.sqlpostgrestest.entity.MyTableEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MyTableRepository {
    final
    EntityManager entityManager;

    public MyTableRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Set<MyTableEntity> getValuesByKod(Short kod){
        Set<MyTableEntity> entities = (Set<MyTableEntity>) entityManager
                .createNativeQuery("SELECT * FROM test.my_table mt WHERE mt.kodgg = :kod", MyTableEntity.class)
                .setParameter("kod", kod)
                .getResultList()
                .stream()
                .collect(Collectors.toSet());
        return entities;
    }
}
