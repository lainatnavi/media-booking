package com.mbooking.config;

import com.mbooking.dao.BookRepository;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

@Configuration
@ConfigurationProperties("oracle")
public class OracleConfig {
    private static Logger log = LoggerFactory.getLogger(OracleConfig.class);

    @NotNull
    private String user;

    @NotNull
    private String password;

    @NotNull
    private String url;

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            log.info("configurations........................");
            for (int i = 0; i<10; i++) {
                System.out.println("......................................");
            }
        };
    }

    @Bean
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

