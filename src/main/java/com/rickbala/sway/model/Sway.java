package com.rickbala.sway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sway {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text; //TODO limited to 2000 chars in the database

    public Sway() {
    }

    public Sway(String text) {
        this.text = text;
    }

    public Sway(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
