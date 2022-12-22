package ru.phoenixit.EntranceTest.phoenix.education.models;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private Integer duration;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @Column(name = "department_id", updatable = false, insertable = false)
    private Integer departmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", department=" + department +
                ", departmentId=" + departmentId +
                '}';
    }
}
