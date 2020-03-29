package com.kodilla.patterns2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class
})
public class KodillaPatterns2Application {

    public static void main(String[] args) {
        SpringApplication.run(KodillaPatterns2Application.class, args);
    }

}
