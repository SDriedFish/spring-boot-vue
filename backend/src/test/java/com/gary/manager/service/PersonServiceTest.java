package com.gary.manager.service;

import com.gary.manager.bean.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void findOne() {
        Person personA = personService.findOne(1);
        Person personB = new Person("emm", 23);
        Assert.assertEquals(personB, personA);
    }


    @Test
    public void findAll() {
        List<Person> personList = personService.findAll();

        Assert.assertEquals(6, personList.size());
    }
}