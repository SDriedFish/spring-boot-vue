package com.gary.manager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * Date: 2018/4/23
 * Time: 22:43
 */
@Aspect
@Component
public class PersonAspect {
    private final static Logger logger = LoggerFactory.getLogger(PersonAspect.class);

    @Pointcut("execution(public * com.gary.manager.controller.PersonController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        logger.info("method={}", request.getMethod());

        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("PersonAspect After");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}