package com.example.employeesmanagement.services.dto;

import java.io.Serializable;

public class SexDTO implements Serializable {
    private int id;

    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SexDTO{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
