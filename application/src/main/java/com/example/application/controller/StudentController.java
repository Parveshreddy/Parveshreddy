package com.example.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entity.StudentEntity;
import com.example.application.service.StudentService;
import com.example.exception.ResourceNotFoundException;

import jakarta.validation.Valid;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired

	private StudentService studentService;
	
	@PostMapping("/students")

	public StudentEntity createStudent(@Valid @RequestBody StudentEntity student) {

	//displaying student object in console for confirmation

	System.out.println(student);

	return studentService.createStudent(student);

	}
	
	@GetMapping ("/students")
	public List<StudentEntity> getAllStudents() {
		//storing return type of Student Entity
		return studentService.getAll();
	}
	
	@PutMapping("/students/{id}")
	
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value = "id") Long studentId,
	@Valid @RequestBody StudentEntity studentDetails) throws ResourceNotFoundException {
	StudentEntity student = studentService.findByStudentId(studentId)
	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	student.setFirstName(studentDetails.getFirstName());
	final StudentEntity updatedStudent = studentService.save(student);
	return ResponseEntity.ok(updatedStudent);

	}
	@DeleteMapping("/students/{id}")
	
	public Map<Object, Object> deleteStudent(@PathVariable(value = "id") Long studentId)
	throws ResourceNotFoundException {
	StudentEntity student = studentService.findByStudentId(studentId)
	.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
	studentService.delete(student);
	Map<Object, Object> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
	}
}
