package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_section")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String section_name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_supervisor")
    private Supervisor supervisor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section", cascade = {
            CascadeType.PERSIST})
    private List<DistributionSchedule> distributionSchedules;

    public Section() {
    }

    public Section(@NotBlank String section_name, Supervisor supervisor) {
        super();
        this.section_name = section_name;
        this.supervisor = supervisor;
    }

    public List<DistributionSchedule> getDistributionSchedules() {
        return distributionSchedules;
    }

    public void setDistributionSchedules(List<DistributionSchedule> distributionSchedules) {
        this.distributionSchedules = distributionSchedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
