package com.spring.boot.demo.service;

import com.spring.boot.demo.StudentRepository;
import com.spring.boot.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {

        Student student = Student.builder().name("student1").
                age(20).
                email("student1@gmail.com").
                build();
        Mockito.when(studentRepository.findStudentByEmail("student1@gmail.com")).
                thenReturn(java.util.Optional.ofNullable(student));
    }

    @Test
    @DisplayName("Find student By Email id")
    public void whenValidStudentEmail_thenFindStudent() {
        String emailId = "student@gmail.com";
        Student student = studentService.findStudentByEmailID((emailId));
        assertEquals(student.getEmail(), emailId);
    }
}