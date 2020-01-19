package com.rickbala.sway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sway {

    @Id
    @GeneratedValue
    private Long id;
    private String sway; //TODO limited to 2000 chars in the database

    public Sway() {
    }

    public Sway(String text) {
        this.sway = text;
    }

    public Sway(Long id, String sway) {
        this.id = id;
        this.sway = sway;
    }

    @Override
    public String toString() {
        return "Sway{" +
                "id=" + id +
                ", sway='" + sway + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSway() {
        return sway;
    }

    public void setSway(String sway) {
        this.sway = sway;
    }

}
