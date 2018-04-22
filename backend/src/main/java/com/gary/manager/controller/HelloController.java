package com.gary.manager.controller;

import com.gary.manager.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/18
 * Time: 23:16
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PersonProperties personProperties;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("id") Integer id) {
        return "你好 Spring Boot and port is " + port + ".My name is " + personProperties.getName() + ":" + id;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "id", defaultValue = "0", required = false) Integer myId) {
        return "Hello Spring Boot and port is " + port + ".My name is " + personProperties.getName() + ":" + myId;
    }
}
