package com.dictionary.learner;

import com.dictionary.learner.entity.Role;
import com.dictionary.learner.entity.User;
import com.dictionary.learner.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class LearnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnerApplication.class, args);
    }

}
