package com.lizoon.touristclub.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="planned_hike")
public class PlannedHike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_planned_hike")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plannedHike", cascade = {
            CascadeType.PERSIST})
    private List<TypeOfHike> typeOfHikes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST})
    @JoinColumn(name = "id_plan")
    private Plan plan;

    public PlannedHike(){super();}

    public PlannedHike(String name, List<TypeOfHike> typeOfHikes, Plan plan) {
        this.name = name;
        this.typeOfHikes = typeOfHikes;
        this.plan = plan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeOfHike> getTypeOfHikes() {
        return typeOfHikes;
    }

    public void setTypeOfHikes(List<TypeOfHike> typeOfHikes) {
        this.typeOfHikes = typeOfHikes;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
