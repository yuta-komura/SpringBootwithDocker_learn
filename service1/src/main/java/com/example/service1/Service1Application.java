package com.example.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Service1Application {

    private final UserService userService;

    @Autowired
    public Service1Application(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        List<User> users = userService.selectById();
        return "Hello World service1 first user is " + users.getFirst().name;
    }


    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

}
