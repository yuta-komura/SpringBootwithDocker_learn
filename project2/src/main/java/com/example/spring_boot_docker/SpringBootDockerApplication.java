package com.example.spring_boot_docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

    private final UserService userService;

    @Autowired
    public SpringBootDockerApplication(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        List<User> users = userService.selectById();
        return "Hello Docker World project2 user is " + users.getFirst().name;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerApplication.class, args);
    }

}
