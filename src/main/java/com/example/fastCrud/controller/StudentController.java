package com.example.fastCrud.controller;

import com.example.fastCrud.model.Student;
import com.example.fastCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    private  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long id){
        return this.studentService.getStudent(id);
    }

    @PostMapping
    public void save(@RequestBody Student student){
        this.studentService.save(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long id){
        this.studentService.delete(id);
    }



}