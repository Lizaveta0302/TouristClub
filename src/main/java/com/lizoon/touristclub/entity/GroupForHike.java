package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="group_for_hike")
public class GroupForHike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_group_for_hike")
    private Long id;

    @NotNull
    @Column(name="number_group")
    private int number_group;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupForHike", cascade = {
            CascadeType.PERSIST})
    private List<Tourist> tourists;

    public GroupForHike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber_group() {
        return number_group;
    }

    public void setNumber_group(int number_group) {
        this.number_group = number_group;
    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }
}
