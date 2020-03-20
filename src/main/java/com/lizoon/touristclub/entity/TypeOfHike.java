package com.lizoon.touristclub.entity;

import javax.persistence.*;

@Entity
@Table(name="type_hike")
public class TypeOfHike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_type_hike")
    private Long id_hike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_hike")
    private Hike hike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_planned_hike")
    private PlannedHike plannedHike;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_unplanned_hike")
    private UnplannedHike unplannedHike;

    public TypeOfHike(){super();}

    public TypeOfHike(Hike hike, PlannedHike plannedHike, UnplannedHike unplannedHike) {
        this.hike = hike;
        this.plannedHike = plannedHike;
        this.unplannedHike = unplannedHike;
    }

    public Long getId_hike() {
        return id_hike;
    }

    public void setId_hike(Long id_hike) {
        this.id_hike = id_hike;
    }

    public Hike getHike() {
        return hike;
    }

    public void setHike(Hike hike) {
        this.hike = hike;
    }

    public PlannedHike getPlannedHike() {
        return plannedHike;
    }

    public void setPlannedHike(PlannedHike plannedHike) {
        this.plannedHike = plannedHike;
    }

    public UnplannedHike getUnplannedHike() {
        return unplannedHike;
    }

    public void setUnplannedHike(UnplannedHike unplannedHike) {
        this.unplannedHike = unplannedHike;
    }
}

