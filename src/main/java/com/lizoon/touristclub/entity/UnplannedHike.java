package com.lizoon.touristclub.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unplanned_hike")
public class UnplannedHike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_unplanned_hike")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unplannedHike", cascade = {
            CascadeType.PERSIST})
    private List<TypeOfHike> typeOfHikes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_route_unplanned")
    private Route route;

    public UnplannedHike(){super();}

    public UnplannedHike(String name, List<TypeOfHike> typeOfHikes, Route route) {
        this.name = name;
        this.typeOfHikes = typeOfHikes;
        this.route = route;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
