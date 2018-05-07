package com.gary.manager.repository;

import com.gary.manager.bean.Person;
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

    /**
    * findByAge
    * @author Administrator
    * @param age
    * @date 2018/5/3 23:36
    * @return java.util.List<com.gary.manager.bean.Person>
    */
    List<Person> findByAge(Integer age);

//    @Query("select * from person t where t.name = ?1")
//    List<Person> findByPersonName(String myName);
}