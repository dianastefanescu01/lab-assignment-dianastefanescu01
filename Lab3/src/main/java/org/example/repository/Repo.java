package org.example.repository;

import org.example.model.DBConnection;
import org.example.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repo {
    public void addStudent(String name, int age){
        String sql = "INSERT INTO Students(name, age) VALUES (?, ?)";
        try(Connection con = DBConnection.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student added!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(int id, String newName, int newAge){
        String sql = "UPDATE Students SET name = ?, age = ? WHERE ID = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Student updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getStudentsByAge(int minAge) {
        String sql = "SELECT * FROM Students WHERE age >= ?";
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, minAge);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(rs.getInt("ID"), rs.getString("name"), rs.getInt("age")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
