package ru.razum0ff.sqlpostgrestest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс сущность тестовой таблицы name_id, схема test
 * Таблица заполнена случайными значениями для практики оптимизации запросов к БД
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "test", name = "name_id")
public class NameIdEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "kod")
    private Short kod;

    @Column(name = "name")
    private String name;

    @Column(name = "date_write")
    private LocalDate dateWrite;
}
