package com.spring.boot.demo;

import com.spring.boot.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager EntityManager;

    @BeforeEach
    void setUp() {
        Student student = Student.builder().name("student1").
                age(20).
                email("student1@gmail.com").
                build();
        EntityManager.persist(student);
    }

    @Test
    public void whenFindById_thenReturnStudent() {
        Student student = studentRepository.findById(1L).get();
        assertEquals(student.getName(), "student1");
    }
}