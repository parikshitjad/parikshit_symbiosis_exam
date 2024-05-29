package com.student.StudentManagement.services;

import java.util.List;

import com.student.StudentManagement.model.Student;

public interface StudentServices {
	
	public Student saveRegistered(Student student);
	
	public List<Student> studentList();

	public void deleteByID(int id);

	public Student findByID(int id);

	public void updateStudent(Object student);

	void deleteById(int s);

}
