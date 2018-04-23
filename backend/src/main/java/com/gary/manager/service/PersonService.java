package com.gary.manager.service;

import com.gary.manager.bean.Person;
import com.gary.manager.enums.ResultEnum;
import com.gary.manager.exception.PersonException;
import com.gary.manager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/23
 * Time: 22:19
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackOn = Exception.class)
    public void insertTwo() {
        Person personA = new Person();
        personA.setName("A");
        personA.setAge(18);
        personRepository.save(personA);
        Person personB = new Person();
        personB.setName("B");
        personB.setAge(20);
        personRepository.save(personB);
    }

    public void getAgeById(Integer id) throws Exception {
        final Integer primaryAge = 12;
        final Integer middleAge = 15;
        Person person = personRepository.getOne(id);

        Integer age = person.getAge();
        if (age <= primaryAge) {
            throw new PersonException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > primaryAge && age < middleAge) {
            throw new PersonException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            throw new Exception("异常");
        }

    }

    public Person findOne(Integer id) {
        return personRepository.findById(id).get();
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
