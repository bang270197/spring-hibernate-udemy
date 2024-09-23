package com.hibernate.jdbc;


import com.hibernate.jdbc.jdbc.Person;
import com.hibernate.jdbc.jdbc.PersonJdbcDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    @Override
    public void run(String... args) throws Exception {
        List<Person> persons = personJdbcDao.findAll();
        logger.info("persons: {}", persons.toString());
        Person person = personJdbcDao.findById(200);
        logger.info("person: {}", person.toString());
        logger.info("deleteById: {}", personJdbcDao.deleteById(300));
        logger.info("after delete: {}", persons.toString());

//        personJdbcDao.insert(new Person(500, "BANG", "HN", new Date()));
//        personJdbcDao.insert(new Person(600, "BANG1", "HCM", new Date()));
//        personJdbcDao.insert(new Person(200, "BANG2", "HN", new Date()));
//        personJdbcDao.insert(new Person(300, "BANG3", "HG", new Date()));

        logger.info("persons after insert: {}", persons.toString());
        personJdbcDao.update(new Person(500, "CCC", "DASD", new Date()));
        logger.info("person after update: {}", persons.toString());
        logger.info("Persons findAll1 {}", personJdbcDao.findAll1().toString());

    }
}
