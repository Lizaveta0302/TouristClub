package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supervisor")
    private Long id_supervisor;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "last_name")
    private String last_name;

    @NotBlank
    @Column(name = "patronymic")
    private String patronymic;

    @NotNull
    @Column(name = "salary")
    private int salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supervisor", cascade = {
            CascadeType.PERSIST})
    private List<Section> sections;


    public Supervisor() {
    }

    public Supervisor(@NotBlank String name, @NotBlank String last_name,
                      @NotBlank String patronymic, @NotNull int salary) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.salary = salary;
    }

    public Supervisor(@NotBlank String name, @NotBlank String last_name,
                      @NotBlank String patronymic, @NotNull int salary, List<Section> sections) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.salary = salary;
        this.sections = sections;
    }

    public Long getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(Long id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
