package com.gary.manager.controller;

import com.gary.manager.Person;
import com.gary.manager.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/19
 * Time: 23:37
 */
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getperson")
    public List<Person> getPerson() {
        return personRepository.findAll();
    }

    /**
     * "/addperson?name=test&age=20"
     */
    @PostMapping("/addperson")
    public Person addPerson(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    @PostMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/updateperson")
    public Person updatePerson(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    @GetMapping("/getbyage/{age}")
    public List<Person> getPersonByAge(@PathVariable("age") Integer age) {
        return personRepository.findByAge(age);
    }
}