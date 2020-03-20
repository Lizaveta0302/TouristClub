package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_plan")
    private Long id_plan;

    @NotBlank
    @Column(name="number_of_parking")
    private Integer number_of_parking;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST})
    @JoinColumn(name="id_route_plan")
    private Route route;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plan", cascade = {CascadeType.PERSIST})
    private List<PlannedHike> plannedHikes;

    public Plan(){
        super();
    }

    public Plan(@NotBlank Integer number_of_parking, Route route, List<PlannedHike> plannedHikes) {
        this.number_of_parking = number_of_parking;
        this.route = route;
        this.plannedHikes = plannedHikes;
    }

    public Long getId_plan() {
        return id_plan;
    }

    public void setId_plan(Long id_plan) {
        this.id_plan = id_plan;
    }

    public Integer getNumber_of_parking() {
        return number_of_parking;
    }

    public void setNumber_of_parking(Integer number_of_parking) {
        this.number_of_parking = number_of_parking;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<PlannedHike> getPlannedHikes() {
        return plannedHikes;
    }

    public void setPlannedHikes(List<PlannedHike> plannedHikes) {
        this.plannedHikes = plannedHikes;
    }
}
