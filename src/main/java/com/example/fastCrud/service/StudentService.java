package com.example.fastCrud.service;

import com.example.fastCrud.dao.StudentRepository;
import com.example.fastCrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
