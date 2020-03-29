package com.mbooking.config;

import com.mbooking.model.Book;
import com.mbooking.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
//            repository.save(new Book(4L,"AAAAA", "bbbbb"));
            log.info("configurationsssssssssssss........................");
            for (int i = 0; i<10; i++) {
                System.out.println("....................................");
            }
        };
    }
}

