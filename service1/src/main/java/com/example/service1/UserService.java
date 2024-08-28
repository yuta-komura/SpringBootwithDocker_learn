package com.example.service1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserDao userDao;

  @Autowired
  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public List<User> selectById() {
    User user = new User(1L, null);
    return userDao.selectById(user.id);
  }
}
