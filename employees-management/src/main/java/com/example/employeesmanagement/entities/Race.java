package com.example.employeesmanagement.entities;

import javax.persistence.*;

/**
 * Define EntityObject Class to map with Entity Object in DB
 * EntityObject: Race
 * Table In DB: races
 */
@Entity
@Table(name = "races")
public class Race {
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
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
