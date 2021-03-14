package com.example.employeesmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "relationships")
public class Relationship {
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
        return "Relationship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
