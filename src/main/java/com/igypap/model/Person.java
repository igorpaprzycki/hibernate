package com.igypap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by igypap on 29.01.17.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
