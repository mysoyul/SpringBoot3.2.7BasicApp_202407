package com.basic.myspringboot.runner;

import com.basic.myspringboot.config.vo.CustomerVO;
import com.basic.myspringboot.property.MybootProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    @Value("${myboot.fullName}")
    private String fullName;

    @Autowired
    MybootProperties properties;

    @Autowired
    CustomerVO customerBean;

    private Logger logger = LoggerFactory.getLogger(MyRunner.class);

    public void run(ApplicationArguments args) throws Exception {
        logger.info("Logger 구현체 클래스 이름 = {}", logger.getClass().getName());
        logger.info("Profile CustomerVO = {}", customerBean);
        logger.info("properties 환경변수 ${myboot.name} = {}", name);
        logger.info("properties 환경변수 ${myboot.age} = {}", age);
        logger.info("properties 환경변수 ${myboot.fullName} = {}", fullName);

        logger.debug("MybootProperties 객체 getAge() = {}", properties.getAge());
        logger.debug("MybootProperties 객체 getFullName() = {}", properties.getFullName());

        logger.debug("VM arguments foo : {}", args.containsOption("foo")); //false
        logger.debug("Program arguments bar : {}", args.containsOption("bar")); //true

        args.getOptionNames()//Set<String>
                //Iterable의 forEach(Consumer) Consumer의 추상메서드 void accept(T t);
                .forEach(name -> System.out.println(name));

//        args.getOptionValues("spring.application.name")
//                .forEach(value -> System.out.println(value));
    }
}