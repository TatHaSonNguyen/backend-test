package com.example.employeesmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "age")
    private int age;

    @ManyToOne
    private Workclass workclass;

    @ManyToOne
    private EducationLevel educationLevel ;

    @Column(name = "education_num")
    private int education_num;

    @ManyToOne
    private MaritalStatus maritalStatus ;

    @ManyToOne
    private Occupation occupation ;

    @ManyToOne
    private Relationship relationship;

    @ManyToOne
    private Race race ;

    @ManyToOne
    private Sex sex ;

    @Column(name = "capital_gain")
    private int capital_gain;

    @Column(name = "capital_loss")
    private int capital_loss ;

    @Column(name = "hours_week")
    private int hours_week ;

    @ManyToOne
    private Country country ;

    @Column(name = "over_50k")
    private boolean over_50k ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Workclass getWorkclass() {
        return workclass;
    }

    public void setWorkclass(Workclass workclass) {
        this.workclass = workclass;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public int getEducation_num() {
        return education_num;
    }

    public void setEducation_num(int education_num) {
        this.education_num = education_num;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getCapital_gain() {
        return capital_gain;
    }

    public void setCapital_gain(int capital_gain) {
        this.capital_gain = capital_gain;
    }

    public int getCapital_loss() {
        return capital_loss;
    }

    public void setCapital_loss(int capital_loss) {
        this.capital_loss = capital_loss;
    }

    public int getHours_week() {
        return hours_week;
    }

    public void setHours_week(int hours_week) {
        this.hours_week = hours_week;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isOver_50k() {
        return over_50k;
    }

    public void setOver_50k(boolean over_50k) {
        this.over_50k = over_50k;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", workclass=" + workclass +
                ", educationLevel=" + educationLevel +
                ", education_num=" + education_num +
                ", maritalStatus=" + maritalStatus +
                ", occupation=" + occupation +
                ", relationship=" + relationship +
                ", race=" + race +
                ", sex=" + sex +
                ", capital_gain=" + capital_gain +
                ", capital_loss=" + capital_loss +
                ", hours_week=" + hours_week +
                ", country=" + country +
                ", over_50k=" + over_50k +
                '}';
    }
}
