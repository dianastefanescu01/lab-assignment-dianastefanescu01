package org.example;

import org.example.model.Student;
import org.example.repository.Repo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Repo repository = new Repo();

        // Add a new student
        repository.addStudent("Alice", 22);

        // Modify existing student
        repository.updateStudent(1, "Alice Smith", 23);

        // Retrieve students older than 20
        List<Student> students = repository.getStudentsByAge(20);
        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge());
        }
    }
}