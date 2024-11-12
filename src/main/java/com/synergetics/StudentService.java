package com.synergetics;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.*;

@Service
public class StudentService {
    private Map<Integer, Student> studentRepository = new HashMap<>();
    private int currentId = 1;

    // Initialize some students with @PostConstruct to populate data at startup
    @PostConstruct
    public void initializeData() {
        addStudent(new Student(0, "Alice Johnson", 20));
        addStudent(new Student(0, "Bob Smith", 22));
        addStudent(new Student(0, "Cathy Lee", 19));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentRepository.values());
    }

    public Student getStudentById(int id) {
        return studentRepository.get(id);
    }

    public Student addStudent(Student student) {
        student.setId(currentId++);
        studentRepository.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        if (studentRepository.containsKey(id)) {
            student.setId(id);
            studentRepository.put(id, student);
            return student;
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return studentRepository.remove(id) != null;
    }
}
