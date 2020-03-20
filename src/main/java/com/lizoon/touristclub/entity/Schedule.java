package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_schedule")
    private Long id_schedule;

    @NotBlank
    @Column(name="place")
    private String place;

    @Column(name="data")
    private Timestamp data;

    @Column(name="duration")
    private int duration;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule", cascade = {
            CascadeType.PERSIST})
    private List<DistributionSchedule> distributionSchedules;


    public Schedule() {
        super();
    }

    public Schedule(@NotBlank String place, Timestamp data, int duration){
        this.place = place;
        this.data = data;
        this.duration = duration;
    }

    public List<DistributionSchedule> getDistributionSchedules() {
        return distributionSchedules;
    }

    public void setDistributionSchedules(List<DistributionSchedule> distributionSchedules) {
        this.distributionSchedules = distributionSchedules;
    }

    public Long getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(Long id_schedule) {
        this.id_schedule = id_schedule;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
