package com.igypap.dao;

import com.igypap.model.Person;

import java.util.List;

/**
 * Created by igypap on 29.01.17.
 */
public interface PersonDao {
    void save(Person person);
    List getAll();
    List<Person> findBySurname(String surname);

}
