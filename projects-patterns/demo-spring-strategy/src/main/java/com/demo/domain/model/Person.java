package com.demo.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person {

  @Id private String id;
  private String name;
  private String email;

  public Person() {}

  public Person(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Person(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  @Override
  public String toString() {
    return "Person [id=" + this.id + ", name=" + this.name + ", email=" + this.email + "]";
  }
}
