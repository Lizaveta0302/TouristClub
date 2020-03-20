package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_route")
    private Long id_route;

    @NotNull
    @Column(name="number_of_days")
    private int number_of_days;

    @Column(name="data_start")
    private Timestamp data_start;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = {
            CascadeType.PERSIST})
    private List<UnplannedHike> unplannedHikes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = {
            CascadeType.PERSIST})
    private List<Plan> plans;

    public Route(){
        super();
    }

    public Route(@NotBlank Integer number_of_days, @NotBlank Timestamp data_start) {
        this.number_of_days = number_of_days;
        this.data_start = data_start;
    }

    public Long getId_route() {
        return id_route;
    }

    public void setId_route(Long id_route) {
        this.id_route = id_route;
    }

    public Integer getNumber_of_days() {
        return number_of_days;
    }

    public void setNumber_of_days(Integer number_of_days) {
        this.number_of_days = number_of_days;
    }

    public List<UnplannedHike> getUnplannedHikes() {
        return unplannedHikes;
    }

    public void setUnplannedHikes(List<UnplannedHike> unplannedHikes) {
        this.unplannedHikes = unplannedHikes;
    }

    public Timestamp getData_start() {
        return data_start;
    }

    public void setData_start(Timestamp data_start) {
        this.data_start = data_start;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
