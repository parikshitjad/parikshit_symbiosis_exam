package com.student.StudentManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.StudentManagement.dao.StudentRepo;
import com.student.StudentManagement.model.Student;

@Service
public class StudentServicesImp implements StudentServices{
	@Autowired
	private StudentRepo  employeeRepo;
	
	@Override
	public Student saveRegistered(Student employee) {
		// TODO Auto-generated method stub
		return studentRepo.save(employee);
	}

	@Override
	public List<Student> studentList() {
		List<student> findAll = studentRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
		
	}