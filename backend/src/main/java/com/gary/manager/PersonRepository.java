package com.gary.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/19
 * Time: 23:39
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findByAge(Integer age);
}