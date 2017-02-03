package com.igypap.controller;

import com.igypap.dao.PersonDao;
import com.igypap.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by igypap on 29.01.17.
 */
@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;

    @GetMapping("/people/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("person", new Person());
        return "people/add";
    }

    @PostMapping("/people/create")
    public String create(@ModelAttribute Person person, ModelMap modelMap) {
        modelMap.addAttribute("person", person);
        personDao.save(person);

        return "redirect:success";
    }

    @GetMapping("/people/success")
    public String success(ModelMap modelMap) {
        return "people/success";
    }

    @GetMapping("/people/search")
    public String search(ModelMap modelMap) {
        modelMap.addAttribute("person", new Person());
        return "people/search";
    }

    @PostMapping("people/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap) {
        List<Person> people = personDao.findBySurname(person.getSurname());
        modelMap.addAttribute("persons", people);
        return "people/results";
    }

    @GetMapping("people/all")
    public String listAll(ModelMap modelMap) {
        List<Person> people = personDao.getAll();
        modelMap.addAttribute("persons", people);
        return "people/results";
    }
}
