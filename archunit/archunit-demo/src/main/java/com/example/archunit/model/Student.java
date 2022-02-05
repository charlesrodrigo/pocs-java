package com.example.archunit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table 
public class Student {
	
	@Column
	@Id
	private Long id;
	
	@Column 
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private String email;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
}
