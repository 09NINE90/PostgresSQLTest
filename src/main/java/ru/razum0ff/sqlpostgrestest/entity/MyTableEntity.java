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
 * Класс сущность тестовой таблицы my_table, схема test
 * Таблица заполнена случайными значениями для практики оптимизации запросов к БД
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "test", name = "my_table")
public class MyTableEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Byte age;

    @Column(name = "kodgg")
    private Short kodGG;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "date_write")
    private LocalDate dateWrite;
}
