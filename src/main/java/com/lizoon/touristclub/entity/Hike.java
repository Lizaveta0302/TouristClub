package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="hike")
public class Hike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_hike")
    private Long id;

    @NotBlank
    @Column(name="name")
    private String hike_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hike", cascade = {
            CascadeType.PERSIST})
    private List<TypeOfHike> typeOfHikes;

    public  Hike(){
        super();
    }

    public Hike(@NotBlank String hike_name) {
        this.hike_name = hike_name;
    }

    public List<TypeOfHike> getTypeOfHikes() {
        return typeOfHikes;
    }

    public void setTypeOfHikes(List<TypeOfHike> typeOfHikes) {
        this.typeOfHikes = typeOfHikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHike_name() {
        return hike_name;
    }

    public void setHike_name(String hike_name) {
        this.hike_name = hike_name;
    }
}
