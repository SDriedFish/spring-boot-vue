package com.gary.manager.controller;

import com.gary.manager.bean.Person;
import com.gary.manager.bean.Result;
import com.gary.manager.enums.ResultEnum;
import com.gary.manager.repository.PersonRepository;
import com.gary.manager.service.PersonService;
import com.gary.manager.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private PersonService personService;

    @GetMapping("/getPersons")
    public List<Person> getPerson() {
        return personService.findAll();
    }

    /**
     * "/addperson?name=test&age=20"
     */
    @PostMapping("/addPerson")
    public Result<Person> addPerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResultUtil.error(ResultEnum.ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());

        return ResultUtil.success(personRepository.save(person));
    }

    @PostMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/updatePerson")
    public Person updatePerson(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    @GetMapping("/getByAge/{age}")
    public List<Person> getPersonByAge(@PathVariable("age") Integer age) {
        return personRepository.findByAge(age);
    }

    @GetMapping(value = "/getAgeById/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        personService.getAgeById(id);
    }
}