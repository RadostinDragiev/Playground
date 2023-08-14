package com.dockerdemo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "universities")
public class University extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany
    private Set<Student> students;

    @ManyToMany
    private Set<Teacher> teachers;

    public University() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
