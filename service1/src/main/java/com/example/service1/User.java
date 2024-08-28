package com.example.service1;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity(immutable = true)
public class User {
  @Id public final Long id;
  public final String name;

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
