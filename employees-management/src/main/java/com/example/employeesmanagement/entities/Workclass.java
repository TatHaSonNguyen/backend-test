package com.example.employeesmanagement.entities;

import javax.persistence.*;

/**
 * Define EntityObject Class to map with Entity Object in DB
 * EntityObject: Workclass
 * Table In DB: workclasses
 */
@Entity
@Table(name = "workclasses")
public class Workclass {
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
        return "Workclass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
