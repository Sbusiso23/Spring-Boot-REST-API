package com.example.demo.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	private Integer std_num;
	
	private String name;
	private String course;
	
	public void setStdNum(Integer std_num) {
		this.std_num = std_num;
	}
	
	public Integer getStdNum() {
		return this.std_num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getCourse() {
		return this.course;
	}
}

