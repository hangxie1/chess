package com.hang.chess.application;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication (scanBasePackages={"com.hang.chess"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Chess implements CommandLineRunner {

    
    private final Logger logger = LoggerFactory.getLogger(Chess.class.getName());
   
    
    public static void main(String[] args) {
 
	SpringApplication.run(Chess.class, args);
    }

    @Override
    public void run(String... args) {
        logger.debug("Entering Chess::run");
    }
        
}
