package com.gary.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/18
 * Time: 23:16
 */
@SpringBootApplication
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
