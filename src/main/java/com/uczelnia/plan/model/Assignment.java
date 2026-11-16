package com.uczelnia.plan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "student_group_id")
    private StudentGroup studentGroup;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "lecture_hours")
    private int lectureHours;

    @Column(name = "classes_hours")
    private int classesHours;

    @Column(name = "lab_hours")
    private int labHours;

    @Column(name = "project_hours")
    private int projectHours;

    @Column(name = "has_errors")
    private boolean hasErrors;

    @Column(name = "error_messages", length = 1000)
    private String errorMessages;

    public Assignment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(int lectureHours) {
        this.lectureHours = lectureHours;
    }

    public int getClassesHours() {
        return classesHours;
    }

    public void setClassesHours(int classesHours) {
        this.classesHours = classesHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public int getProjectHours() {
        return projectHours;
    }

    public void setProjectHours(int projectHours) {
        this.projectHours = projectHours;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public String getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }
}
