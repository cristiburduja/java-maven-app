package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;


@SpringBootApplication
public class Application {

    public static void main(String[] args)
    {    System.out.print("Sunt tare");

        SpringApplication.run(Application.class, args);
        System.out.print("Sunt tare");
        System.out.print("Sunt tare");
        System.out.print("Sunt tare");

    }

    @PostConstruct
    public void init()
    {
        Logger log = LoggerFactory.getLogger(Application.class);
        log.info("Java app started");

    }

    public String getStatus() {

        System.out.print("Sunt tare");
        System.out.print("Sunt tare");
        System.out.print("Sunt tare");
        return "OK";
    }
}
