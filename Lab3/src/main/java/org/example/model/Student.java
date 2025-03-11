package org.example.model;

public class Student {
    private int ID;
    private String name;
    private int age;

    public Student(int id, String name, int age){
        this.ID = id;
        this.name = name;
        this.age = age;
    }

    public int getId(){return ID;}
    public String getName(){return name;}
    public int getAge(){return age;}
}
