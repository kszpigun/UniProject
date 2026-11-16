package com.uczelnia.plan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "pensum", nullable = false)
    private Integer pensum;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Integer pensum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pensum = pensum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPensum() {
        return pensum;
    }

    public void setPensum(Integer pensum) {
        this.pensum = pensum;
    }
}
