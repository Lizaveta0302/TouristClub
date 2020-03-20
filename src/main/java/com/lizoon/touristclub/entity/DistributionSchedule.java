package com.lizoon.touristclub.entity;

import javax.persistence.*;

@Entity
@Table(name="distribution_schedule")
public class DistributionSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distribution_schedule")
    private Long id_distribution_schedule;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_section_sch")
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_schedule")
    private Schedule schedule;

    public DistributionSchedule() {
        super();
    }

    public DistributionSchedule(Section section,Schedule schedule) {
        this.section = section;
        this.schedule = schedule;
    }

        public Long getId_distribution_schedule() {
        return id_distribution_schedule;
    }

    public void setId_distribution_schedule(Long id_distribution_schedule) {
        this.id_distribution_schedule = id_distribution_schedule;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}