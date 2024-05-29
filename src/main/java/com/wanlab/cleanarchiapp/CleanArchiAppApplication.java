package com.wanlab.cleanarchiapp;

import com.wanlab.cleanarchiapp.infrastructures.config.web.AcceptHeaderResolver;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CleanArchiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanArchiAppApplication.class, args);
    }


    @Bean
    public AcceptHeaderResolver localResolver() {
        return new AcceptHeaderResolver();
    }

}
