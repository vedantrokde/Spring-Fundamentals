package com.code.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.code.exception.StudentNotFoundException;
import com.code.springrest.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    private void loadData() {
        // populating data
        students = new ArrayList<>();
        students.add(new Student(1, "Ram", "G", "ram@gmail.com"));
        students.add(new Student(2, "Ramesh", "H", "ramesh@gmail.com"));
        students.add(new Student(3, "Ramya", "I", "ramya@gmail.com"));
    }

    @GetMapping("/")
    public String home() {
        return "Server started. API is working and responding...!";
    }

    @GetMapping("/student/{studentId}")
    public Student student(@PathVariable("studentId") int studentId) {
        if(studentId>=students.size() || studentId<0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

    @GetMapping("/students")
    public List<Student> students() {
        return students;
    }
}
