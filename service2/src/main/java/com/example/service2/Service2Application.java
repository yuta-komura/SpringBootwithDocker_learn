package com.example.service2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Service2Application {

  private final UserService userService;

  @Autowired
  public Service2Application(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/")
  public String home() {
    List<User> users = userService.selectById();
    return "Hello World service2 first user is " + users.getFirst().name;
  }

  public static void main(String[] args) {
    SpringApplication.run(Service2Application.class, args);
  }
}
