package com.example.spring_boot_docker;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {
    @Select
    List<User> selectById(Long id);
}
