package com.example.employeesmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "marital_statuses")
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaritalStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
