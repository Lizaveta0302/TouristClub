package com.lizoon.touristclub.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name="tourist")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tourist")
    private Long id_tourist;

    @NotBlank
    @Column(name="name")
    private String name;

    @NotBlank
    @Column(name="last_name")
    private String last_name;

    @NotBlank
    @Column(name="patronymic")
    private String patronymic;

    @NotBlank
    @Column(name="gender")
    private String gender;

    @Column(name="birthday")
    private Timestamp birthday;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST})
    @JoinColumn(name="id_group_for_hike")
    private GroupForHike groupForHike;

    public Tourist() {
    }

    public Tourist(@NotBlank String name, @NotBlank String last_name,
                   @NotBlank String patronymic, @NotBlank String gender, @NotBlank Timestamp birthday) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Long getId_tourist() {
        return id_tourist;
    }

    public void setId_tourist(Long id_tourist) {
        this.id_tourist = id_tourist;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public GroupForHike getGroupForHike() {
        return groupForHike;
    }

    public void setGroupForHike(GroupForHike groupForHike) {
        this.groupForHike = groupForHike;
    }
}
