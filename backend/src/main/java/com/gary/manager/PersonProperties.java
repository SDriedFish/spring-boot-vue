package com.gary.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
/**
 * Created with IntelliJ IDEA.
 * @author : Administrator
 * Date: 2018/4/18
 * Time: 23:16
 */
@Component
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
