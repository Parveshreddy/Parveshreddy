package com.example.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.entity.StudentEntity;



@Repository

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	

}
