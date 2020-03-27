package com.mbooking;

import com.mbooking.model.Book;
import com.mbooking.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MBookingApplication {

    private static final Logger log = LoggerFactory.getLogger(MBookingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MBookingApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(BookRepository repository) {
//        return (args -> {
//           repository.save(new Book("1984", "George Orwell", "111-222-333"));
//
//           log.info("Books found with findAll():");
//           log.info("----------------------------");
//           for (Book book : repository.findAll()) {
//               log.info(book.toString());
//           }
//           log.info("");
//        });
//    }
}
