package com.ducdm.cleancode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducdm.cleancode.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
