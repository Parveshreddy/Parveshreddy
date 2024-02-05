package com.example.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.StudentEntity;
import com.example.application.repo.StudentRepository;



@Service

public class StudentService implements StudentInterface{
	@Autowired

	private StudentRepository studentRepository;
	public StudentEntity createStudent(StudentEntity student) {
	   
		return studentRepository.save(student);
	}
	
	public List<StudentEntity> getAll() {

		return studentRepository.findAll();

		}
	public Optional<StudentEntity > findByStudentId(long studentId){

		return studentRepository.findById(studentId);

		}
	public StudentEntity save(StudentEntity student) {
		
		return studentRepository.save(student);
        }
	public void delete(StudentEntity student){

		studentRepository.delete(student);

		}
}