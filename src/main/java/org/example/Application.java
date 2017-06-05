package org.example;

import org.example.dao.BaseDao;
import org.example.domain.*;
import org.example.factory.AnswerFactory;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Created by Kuzmin Evgeny on 11.05.2017.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Bean
    IService mockBaseService(){
        return new BaseService();
    }

    @Bean
    AnswerFactory mockAnswerFactort(){
        return new AnswerFactory();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
