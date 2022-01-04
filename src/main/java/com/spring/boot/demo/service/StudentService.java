package com.spring.boot.demo.service;

import com.spring.boot.demo.controller.StudentController;
import com.spring.boot.demo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents()
    {
        return List.of(new Student(1L,"Mariam",
                "abc@gmail.com",
                LocalDate.of(2000, Month.APRIL,1),
                21));
    }

}
