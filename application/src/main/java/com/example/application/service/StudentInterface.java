package com.example.application.service;

import java.util.List;
import java.util.Optional;

import com.example.application.entity.StudentEntity;



public interface StudentInterface {
	public StudentEntity createStudent(StudentEntity student);
	public List getAll();
	public Optional findByStudentId(long studentId);
	public void delete(StudentEntity student);

}
